package com.matheusxreis.globoplay.data.services

import com.matheusxreis.globoplay.data.dtos.MovieDTO
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.TopRatedMovie
import retrofit2.Call
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/top_rated?api_key=21e949028c69e031512666d316287784&language=pt-BR&page=1")
    suspend fun getAllMovies(): TopRatedMovie

    @GET("/posts")
    fun getMovieById(): Movie
}


