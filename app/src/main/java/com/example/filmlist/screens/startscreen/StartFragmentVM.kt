package com.example.filmlist.screens.startscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlist.data.retrofit.RetrofitRepository
import com.example.filmlist.models.startmodel.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class StartFragmentVM: ViewModel() {
    private val repository = RetrofitRepository()
    private val movies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()

    fun getData(): LiveData<Response<MoviesModel>> {
        return movies
    }

    fun getMovies(){
        viewModelScope.launch {
            movies.value = repository.getMovies()
        }
    }
}