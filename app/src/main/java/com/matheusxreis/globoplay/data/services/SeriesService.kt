package com.matheusxreis.globoplay.data.services

import com.matheusxreis.globoplay.data.entities.TopRatedSerie
import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesService {

    @GET("tv/top_rated")
    suspend fun getAllSeries(
        @Query("api_key") apikey:String,
        @Query("language") language: String,
        @Query("page") page: String
    ):TopRatedSerie
}