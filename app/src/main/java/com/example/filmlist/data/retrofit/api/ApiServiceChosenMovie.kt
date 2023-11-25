package com.example.filmlist.data.retrofit.api

import com.example.filmlist.models.chosenmodel.ChosenMovieModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceChosenMovie {
    @GET("{id}?api_key=d54b063b83bfa247f2ef350acafee7c3&language=ru")
    fun getChosenMovie(@Path("id") id: String): Call<ChosenMovieModel>
}
