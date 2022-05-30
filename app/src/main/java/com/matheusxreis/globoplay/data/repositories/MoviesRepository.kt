package com.matheusxreis.globoplay.data.repositories

import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.services.MoviesService

class MoviesRepository(private val service: MoviesService) {


    public fun  getMovies():List<Movie> = this.service.getAllMovies();

    public fun getMovieById(id: String):Movie? {
        return service.getMovieById(id)
    }



}