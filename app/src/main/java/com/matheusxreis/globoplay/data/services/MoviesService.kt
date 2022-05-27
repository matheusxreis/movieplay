package com.matheusxreis.globoplay.data.services

import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.TechnicalSheet

class MoviesService {

    val tec = TechnicalSheet("a", listOf("a"), 22, "a", "a", "a", "a")

    val movies: List<Movie> = listOf(
         Movie("movie1", "a very, very, very cool movie, you should watch it!", tec),
         Movie("movie2", "a very. very, very cool movie too, but not so much. Watch it, anyway!", tec),
         Movie("movie3", "a not so very cool movie, if i was you, i'd watch the fisrt movie.", tec)
    )


    public fun getAllMovies():List<Movie> = movies;


}