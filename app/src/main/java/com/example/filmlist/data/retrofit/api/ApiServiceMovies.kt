package com.example.filmlist.data.retrofit.api

import com.example.filmlist.models.startmodel.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceMovies {
    @GET("popular?api_key=d54b063b83bfa247f2ef350acafee7c3&language=ru&page=1")
    suspend fun getPopularMovies(): Response<MoviesModel>
}