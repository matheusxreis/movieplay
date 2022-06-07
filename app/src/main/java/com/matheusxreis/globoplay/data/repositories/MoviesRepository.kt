package com.matheusxreis.globoplay.data.repositories

import com.matheusxreis.globoplay.data.dtos.MovieDTO
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.TopRatedMovie
import com.matheusxreis.globoplay.data.services.MoviesService
import com.matheusxreis.globoplay.data.utils.Constants
import com.matheusxreis.globoplay.data.utils.NetworkUtils
import io.github.cdimascio.dotenv.dotenv

var dotenv = dotenv{
    directory="/assets"
    filename="env"
}


val apikey = dotenv["API_KEY_TMDB"]
class MoviesRepository() {


    public suspend fun getMovies():TopRatedMovie{
        return NetworkUtils("https://api.themoviedb.org/3/").MovieService().getAllMovies(apikey, "pt", "1")
    }

    public fun getMovieById(id: String):Movie? {
        return NetworkUtils(Constants.baseUrl).MovieService().getMovieById()
    }


    public suspend fun getAllMovies():TopRatedMovie{


        return NetworkUtils(Constants.baseUrl).MovieService().getAllMovies(apikey, "pt", "1")
    }



}