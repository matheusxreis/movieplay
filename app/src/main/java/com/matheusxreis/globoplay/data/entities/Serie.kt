package com.matheusxreis.globoplay.data.entities

import com.google.gson.annotations.SerializedName

/**
[{"first_air_date":"2021-09-03","genre_ids":[10764],"id":130392,"name":"The D'Amelio Show","origin_country":["US"],"original_language":"en","original_name":"The D'Amelio Show","overview":"De uma escuridão relativa e uma aparente vida normal, ao serem jogados nas luzes de Hollywood da noite para o dia, os D'Amelio enfrentam novos desafios e oportunidades que não poderiam ter imaginado. Charli, Dixie, Heidi e Marc fazem o melhor que podem para ficarem juntos, enquanto tentam se ajustar à vida em Hollywood.","popularity":19.376,"poster_path":"/z0iCS5Znx7TeRwlYSd4c01Z0lFx.jpg","vote_average":9.4,"vote_count":2718}
 */

data class Serie(
    @SerializedName("name")
    val title:String,

    @SerializedName("overview")
    val description:String,

    @SerializedName("id")
    val id: String,

    @SerializedName("original_language")
    val originalLanguage:String,

    @SerializedName("original_name")
    val originalTitle: String,

    @SerializedName("first_air_data")
    val productionYear: String,

    @SerializedName("poster_path")
    val urlImage: String,

    @SerializedName("genre_ids")
    val genreIds: List<String>
)
