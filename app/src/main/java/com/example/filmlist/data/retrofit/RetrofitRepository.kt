package com.example.filmlist.data.retrofit

import com.example.filmlist.data.retrofit.api.RetrofitInstance
import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import com.example.filmlist.models.startmodel.MoviesModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel>{
        return RetrofitInstance.apiMovies.getPopularMovies()
    }

    suspend fun getMovie(): Response<ChosenMovieModel>{
        return RetrofitInstance.apiChosen.getChosenMovie()
    }
}