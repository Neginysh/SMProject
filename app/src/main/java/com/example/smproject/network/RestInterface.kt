package com.example.smproject.network

import com.example.smproject.model.SearchMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestInterface {
    @GET("/")
    fun searchMovieByTitle(
        @Query("s") search: String,
        @Query("apikey") apiKey: String
    ): Call<SearchMovieResponse>
}
