package com.example.filmlist.screens.chosenfilmscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlist.data.retrofit.RetrofitRepository
import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import com.example.filmlist.models.startmodel.MovieItemModel
import com.example.filmlist.models.startmodel.MoviesModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Response
import java.util.function.Consumer

class ChosenFragmentVM: ViewModel() {
    private val repository = RetrofitRepository()
    val movie: MutableLiveData<ChosenMovieModel> = MutableLiveData()
    val chosenMovie: MutableLiveData<MovieItemModel> = MutableLiveData()

    fun getData(): LiveData<ChosenMovieModel> {
        return movie
    }

    fun getMovie(consumer: Consumer<ChosenMovieModel>){
        val id = "${chosenMovie.value?.id}"
        repository.getMovie(id, consumer)
    }
}
