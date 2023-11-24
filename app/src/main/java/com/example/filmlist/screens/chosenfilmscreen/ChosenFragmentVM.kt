package com.example.filmlist.screens.chosenfilmscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlist.data.retrofit.RetrofitRepository
import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import com.example.filmlist.models.startmodel.MovieItemModel
import com.example.filmlist.models.startmodel.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class ChosenFragmentVM: ViewModel() {
    private val repository = RetrofitRepository()
    private val movie: MutableLiveData<Response<ChosenMovieModel>> = MutableLiveData()
    val chosenMovie: MutableLiveData<MovieItemModel> = MutableLiveData()

    fun getData(): LiveData<Response<ChosenMovieModel>> {
        return movie
    }

    fun getMovie(){
        viewModelScope.launch {
            movie.value = repository.getMovie()
        }
    }
}