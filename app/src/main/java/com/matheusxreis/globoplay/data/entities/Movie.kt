package com.matheusxreis.globoplay.data.entities

data class Movie(
    val title: String,
    val id: String,
    val description: String,
    val urlImage: String,
    val technicalSheet: TechnicalSheet
)
