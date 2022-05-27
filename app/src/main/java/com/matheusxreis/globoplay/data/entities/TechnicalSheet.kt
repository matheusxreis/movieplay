package com.matheusxreis.globoplay.data.entities

data class TechnicalSheet(

    val originalName: String,
    val gen: List<String>,
    val episodes: Int,
    val productionYear: String,
    val country: String,
    val direction: String,
    val cast: String,
)
