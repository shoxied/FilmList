package com.example.filmlist.screens.chosenfilmscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.filmlist.IMAGE_BASE_URL
import com.example.filmlist.MAINACT
import com.example.filmlist.R
import com.example.filmlist.databinding.FragmentChosenBinding
import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import com.example.filmlist.models.startmodel.MovieItemModel
import java.util.function.Consumer

class ChosenFragment : Fragment() {

    private var mBinding: FragmentChosenBinding? = null
    private val binding get() = mBinding!!
    private lateinit var chosenMovie: MovieItemModel
    private lateinit var myMovie: ChosenMovieModel

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

    private fun init() {
        val vm = ViewModelProvider(this).get(ChosenFragmentVM::class.java)
        vm.chosenMovie.value = chosenMovie
        vm.getMovie{
            myMovie = it
            Glide.with(MAINACT).load(IMAGE_BASE_URL + myMovie.poster_path)
                .centerCrop().placeholder(R.drawable.avengers_endgame_poster)
                .into(binding.filmImage)
            binding.filmTitle.text = myMovie.title
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}