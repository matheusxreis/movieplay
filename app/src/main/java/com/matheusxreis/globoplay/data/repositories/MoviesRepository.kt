package com.matheusxreis.globoplay.data.repositories

import android.util.Log
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.services.movies.MovieServiceEntity
import com.matheusxreis.globoplay.data.services.movies.TopRatedMovie
import com.matheusxreis.globoplay.data.utils.Constants
import com.matheusxreis.globoplay.data.utils.NetworkUtils
import io.github.cdimascio.dotenv.dotenv

var dotenv = dotenv{
    directory="/assets"
    filename="env"
}


val apikey = dotenv["API_KEY_TMDB"]


class MoviesRepository() {

    public suspend fun getMovies(): List<Movie> {

        val a = NetworkUtils("https://api.themoviedb.org/3/").MovieService().getAllMovies(apikey, "pt", "1").results
        val list: MutableList<Movie> = mutableListOf()
        a.map {
            list.add(mapperServiceMovieToMovie(it))
        }
        return list
    }


    private fun mapperServiceMovieToMovie(serviceMovie: MovieServiceEntity):Movie{

        Log.d("servicemovie", serviceMovie.productionYear)
        return Movie(
            title = serviceMovie.title,
            id = serviceMovie.id,
            description = serviceMovie.description,
            urlImage = serviceMovie.urlImage,
            originalLanguage = serviceMovie.originalLanguage,
            originalTitle = serviceMovie.originalTitle,
            productionYear = serviceMovie.productionYear
        )
    }



}