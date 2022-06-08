package com.matheusxreis.globoplay.data.services.movies

import com.google.gson.annotations.SerializedName

data class MovieServiceEntity(
    @SerializedName("title")
    val title: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("overview")
    val description: String,

    @SerializedName("poster_path")
    val urlImage: String,

    @SerializedName("original_language")
    val originalLanguage:String,

    @SerializedName("original_title")
    val originalTitle:String,

    @SerializedName("release_date")
    val productionYear:String,

)
