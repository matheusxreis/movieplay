package com.matheusxreis.globoplay.ui.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheusxreis.globoplay.data.dtos.MovieDTO
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.TopRatedMovie
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.services.MoviesService
import kotlinx.coroutines.launch

class MainActivityViewModel():ViewModel() {
     var moviesRepository: MoviesRepository = MoviesRepository()

      var movies:MutableLiveData<List<Movie>>;

    init {
        movies = MutableLiveData()
    }
    public fun fetchMovies() {
        viewModelScope.launch {
            val response: TopRatedMovie = moviesRepository.getMovies();

            Log.d("HERE", response.results[0].urlImage.toString())

            movies.postValue(response.results)

        };

    }
    public fun getMovieById(id: String): Movie? {
        return moviesRepository.getMovieById(id)
    }
}