package com.matheusxreis.globoplay.data.entities

import com.google.gson.annotations.SerializedName

data class TopRatedSerie(

    @SerializedName("page")
    val page: Number,

    @SerializedName("results")
    val results: List<Serie>
)