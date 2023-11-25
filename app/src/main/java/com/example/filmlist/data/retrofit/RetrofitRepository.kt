package com.example.filmlist.data.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.filmlist.data.retrofit.api.RetrofitInstance
import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import com.example.filmlist.models.startmodel.MoviesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.function.Consumer
import java.util.function.Supplier

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel>{
        return RetrofitInstance.apiMovies.getPopularMovies()
    }

    fun getMovie(id: String, consumer: Consumer<ChosenMovieModel>) {
        val call = RetrofitInstance.apiChosen.getChosenMovie(id)
        call.enqueue(object : Callback<ChosenMovieModel> {
            override fun onFailure(call: Call<ChosenMovieModel>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ChosenMovieModel>?, response: Response<ChosenMovieModel>?) {
                response?.body()?.let { consumer.accept(it) }
            }
        })
    }
}