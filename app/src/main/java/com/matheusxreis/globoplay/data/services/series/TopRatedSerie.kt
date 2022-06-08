package com.matheusxreis.globoplay.data.services.series

import com.google.gson.annotations.SerializedName

data class TopRatedSerie(

    @SerializedName("page")
    val page: Number,

    @SerializedName("results")
    val results: List<SerieServiceEntity>
)