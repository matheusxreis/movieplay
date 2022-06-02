package com.matheusxreis.globoplay.data.entities

import com.google.gson.annotations.SerializedName

data class TopRatedMovie(

    @SerializedName("page")
     val page: Number,

    @SerializedName("results")
     val results: List<Movie>
)