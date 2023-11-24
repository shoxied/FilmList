package com.example.filmlist.screens.startscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlist.MAINACT
import com.example.filmlist.R
import com.example.filmlist.databinding.FragmentStartBinding
import com.example.filmlist.models.startmodel.MovieItemModel

class StartFragment : Fragment() {

    private var mBinding: FragmentStartBinding? = null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MovieAdapter() }
    private lateinit var buttonFavorite: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val vm = ViewModelProvider(this).get(StartFragmentVM::class.java)
        vm.getMovies()
        recyclerView = binding.rvStart
        recyclerView.adapter = adapter
        vm.getData().observe(this, Observer{list->
            adapter.setMovieList(list.body()!!.results)
        })

        buttonFavorite = binding.menuFavoriteButton
        buttonFavorite.setOnClickListener {
            MAINACT.navController.navigate(R.id.action_startFragment_to_favoriteFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object{
        fun clickMovie(model: MovieItemModel){
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAINACT.navController.navigate(R.id.action_startFragment_to_chosenFragment)
        }
    }

}