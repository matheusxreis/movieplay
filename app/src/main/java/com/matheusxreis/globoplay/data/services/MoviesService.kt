package com.matheusxreis.globoplay.data.services

import com.matheusxreis.globoplay.data.dtos.MovieDTO
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.TopRatedMovie
import retrofit2.Call
import retrofit2.http.GET
import io.github.cdimascio.dotenv.dotenv
import retrofit2.http.Query



interface MoviesService {

    @GET("movie/top_rated")
    suspend fun getAllMovies(
        @Query("api_key") apikey: String,
        @Query("language")language: String,
        @Query("page")page:String
    ): TopRatedMovie

    @GET("/posts")
    fun getMovieById(): Movie
}


