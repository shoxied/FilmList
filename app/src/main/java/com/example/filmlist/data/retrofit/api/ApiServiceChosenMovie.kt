package com.example.filmlist.data.retrofit.api

import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceChosenMovie {
    @GET("?api_key=d54b063b83bfa247f2ef350acafee7c3&language=ru")

    suspend fun getChosenMovie(): Response<ChosenMovieModel>
}