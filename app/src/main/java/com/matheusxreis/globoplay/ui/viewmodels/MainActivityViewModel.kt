package com.matheusxreis.globoplay.ui.viewmodels

import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.repositories.MoviesRepository

class MainActivityViewModel(
    private val moviesRepository: MoviesRepository
) {

    public fun getMovies(): List<Movie> = moviesRepository.getMovies();

    public fun getMovieById(id:String):Movie? {
        return moviesRepository.getMovieById(id)
    }

}