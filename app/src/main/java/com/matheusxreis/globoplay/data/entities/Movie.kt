package com.matheusxreis.globoplay.data.entities

import com.google.gson.annotations.SerializedName

data class Movie(
    val title: String,

    val id: String,

    val description: String,

    val urlImage: String,

    val originalLanguage:String,

    val originalTitle:String,

    val productionYear:String?,
    )
