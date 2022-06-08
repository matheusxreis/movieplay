package com.matheusxreis.globoplay.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.Serie
import com.matheusxreis.globoplay.data.services.series.SerieServiceEntity
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.repositories.SeriesRepository
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
            val response: List<Movie> = moviesRepository.getMovies();

            movies.value = response
        };
    }

    public fun fetchSeries(){
        viewModelScope.launch {
            val response:List<Serie> = seriesRepository.getSeries();
            series.value = response
        }
    }


    public fun getMovieById(id: String): Movie? {
        Log.d("MOVIE_id", id)
    return movies.value?.find { it -> it.id === id};

    }

    public fun likeMovie(id:String){
//        var movie = movies.value?.find { it -> it.id === id};
//
//        liked.add(movie as Movie)
//        likedMovies.postValue(liked)

        }

    public fun getSerieById(id: String): Serie? {
        return series.value?.find { it -> it.id === id};
    }
}