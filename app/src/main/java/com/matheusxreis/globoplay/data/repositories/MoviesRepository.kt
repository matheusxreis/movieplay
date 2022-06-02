package com.matheusxreis.globoplay.data.repositories

import com.matheusxreis.globoplay.data.dtos.MovieDTO
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.TopRatedMovie
import com.matheusxreis.globoplay.data.services.MoviesService
import com.matheusxreis.globoplay.data.utils.NetworkUtils

class MoviesRepository() {


    public suspend fun getMovies():TopRatedMovie{
        return NetworkUtils("https://api.themoviedb.org/3/").MovieService().getAllMovies()
    }

    public fun getMovieById(id: String):Movie? {
        return NetworkUtils("https://api.themoviedb.org/3/").MovieService().getMovieById()
    }


    public suspend fun getAllMovies():TopRatedMovie{


        return NetworkUtils("https://api.themoviedb.org/3/").MovieService().getAllMovies()
    }



}