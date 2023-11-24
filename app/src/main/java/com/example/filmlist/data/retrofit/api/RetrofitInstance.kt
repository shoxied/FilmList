package com.example.filmlist.data.retrofit.api

import com.example.filmlist.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy { Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()}

    val apiMovies: ApiServiceMovies by lazy { retrofit.create(ApiServiceMovies::class.java) }

    val apiChosen: ApiServiceChosenMovie by lazy { retrofit.create(ApiServiceChosenMovie::class.java) }
}