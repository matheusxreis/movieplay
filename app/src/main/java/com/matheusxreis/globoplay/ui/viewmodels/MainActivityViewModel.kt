package com.matheusxreis.globoplay.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.services.MoviesService

class MainActivityViewModel():ViewModel() {
    var moviesService: MoviesService = MoviesService()
     var moviesRepository: MoviesRepository = MoviesRepository(moviesService)

    private var movies:List<Movie> = listOf(); private set

    public fun getMovies(): List<Movie> {
        movies = moviesRepository.getMovies();

        return movies;
    };

    public fun getMovieById(id:String):Movie? {
        return moviesRepository.getMovieById(id)
    }

}