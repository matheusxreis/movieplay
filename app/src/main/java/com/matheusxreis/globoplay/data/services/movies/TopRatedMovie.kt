package com.matheusxreis.globoplay.data.services.movies

import com.google.gson.annotations.SerializedName

data class TopRatedMovie(

    @SerializedName("page")
     val page: Number,

    @SerializedName("results")
     val results: List<MovieServiceEntity>
)