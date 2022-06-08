package com.matheusxreis.globoplay.data.services.movies

import retrofit2.http.GET
import retrofit2.http.Query



interface MoviesService {

    @GET("movie/top_rated")
    suspend fun getAllMovies(
        @Query("api_key") apikey: String,
        @Query("language")language: String,
        @Query("page")page:String
    ): TopRatedMovie


}


