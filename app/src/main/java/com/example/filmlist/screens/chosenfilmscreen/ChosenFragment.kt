package com.example.filmlist.screens.chosenfilmscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.filmlist.IMAGE_BASE_URL_DETAIL
import com.example.filmlist.MAINACT
import com.example.filmlist.R
import com.example.filmlist.databinding.FragmentChosenBinding
import com.example.filmlist.models.startmodel.MovieItemModel
import kotlin.math.roundToInt

class ChosenFragment : Fragment() {

    private var mBinding: FragmentChosenBinding? = null
    private val binding get() = mBinding!!
    private lateinit var chosenMovie: MovieItemModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentChosenBinding.inflate(layoutInflater, container, false)
        chosenMovie = arguments?.getSerializable("movie") as MovieItemModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @SuppressLint("ResourceAsColor")
    private fun init() {
        val vm = ViewModelProvider(this).get(ChosenFragmentVM::class.java)
        vm.chosenMovie.value = chosenMovie
        vm.getMovie{
            Glide.with(MAINACT).load(IMAGE_BASE_URL_DETAIL + it.poster_path)
                .centerCrop().placeholder(R.drawable.baseline_downloading_24).into(binding.filmImage)
            binding.filmTitle.text = it.title
            if (!it.adult) binding.adultText.text = ""
            binding.budgetText.text = "$${it.budget}"
            binding.issueYearText.text = it.release_date.substring(0, 4)
            binding.countryText.text = it.production_countries[0].name
            for (i in 0 until it.genres.size){
                binding.genreText.text = "${binding.genreText.text}${it.genres[i].name}, "
            }
            binding.releaseDateText.text = it.release_date
            binding.voteAverage.text = "${(it.vote_average*10).roundToInt()/10.0}"
            binding.voteCountText.text = "${it.vote_count}"
            binding.revenueText.text = "$${it.revenue}"
            binding.durationText.text = "${it.runtime} мин."
            for (i in 0 until it.production_companies.size){
                binding.companiesText.text = "${binding.companiesText.text}${it.production_companies[i].name}, "
            }
            binding.descriptionText.text = it.overview
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}