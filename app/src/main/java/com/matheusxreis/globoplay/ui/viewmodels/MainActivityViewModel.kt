package com.matheusxreis.globoplay.ui.viewmodels

import android.mtp.MtpConstants
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheusxreis.globoplay.data.dtos.MovieDTO
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.Serie
import com.matheusxreis.globoplay.data.entities.TopRatedMovie
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.repositories.SeriesRepository
import com.matheusxreis.globoplay.data.services.MoviesService
import kotlinx.coroutines.launch

class MainActivityViewModel():ViewModel() {
     var moviesRepository: MoviesRepository = MoviesRepository()
     var seriesRepository: SeriesRepository = SeriesRepository()


      var movies:MutableLiveData<List<Movie>> = MutableLiveData();
      var series:MutableLiveData<List<Serie>> = MutableLiveData()

      var liked: MutableList<Movie> = mutableListOf()
      var likedMovies: MutableLiveData<List<Movie>> = MutableLiveData()

    public fun fetchMovies() {
        viewModelScope.launch {
            val response: TopRatedMovie = moviesRepository.getMovies();

            Log.d("HERE", response.results[0].urlImage.toString())

            movies.value = response.results
        };
    }

    public fun fetchSeries(){
        viewModelScope.launch {
            val response = seriesRepository.getSeries();
            series.value = response
        }
    }


    public fun getMovieById(id: String): Movie? {
        Log.d("MOVIE_id", id)
    return movies.value?.find { it -> it.id === id};
    //return moviesRepository.getMovieById(id)
    }

    public fun likeMovie(id:String){
        var movie = movies.value?.find { it -> it.id === id};

        liked.add(movie as Movie)
        likedMovies.postValue(liked)

        }
}