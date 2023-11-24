package com.example.filmlist.screens.favoritescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlist.databinding.FragmentFavoriteBinding
import com.example.filmlist.screens.startscreen.MovieAdapter

class FavoriteFragment : Fragment() {

    private var mBinding: FragmentFavoriteBinding? = null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val vm = ViewModelProvider(this).get(FavoriteFragmentVM::class.java)
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}