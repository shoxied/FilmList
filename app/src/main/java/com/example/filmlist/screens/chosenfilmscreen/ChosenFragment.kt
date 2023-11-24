package com.example.filmlist.screens.chosenfilmscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.filmlist.databinding.FragmentChosenBinding
import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import com.example.filmlist.models.startmodel.MovieItemModel

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

    private fun init() {
        val vm = ViewModelProvider(this).get(ChosenFragmentVM::class.java)
        vm.chosenMovie.value = chosenMovie
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}