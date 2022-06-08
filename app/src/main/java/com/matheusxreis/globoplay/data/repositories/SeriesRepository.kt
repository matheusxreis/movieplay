package com.matheusxreis.globoplay.data.repositories

import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.Serie
import com.matheusxreis.globoplay.data.services.movies.MovieServiceEntity
import com.matheusxreis.globoplay.data.services.series.SerieServiceEntity
import com.matheusxreis.globoplay.data.utils.Constants
import com.matheusxreis.globoplay.data.utils.NetworkUtils

class SeriesRepository() {

    suspend fun getSeries(): List<Serie> {
        val a = NetworkUtils(Constants.baseUrl).SerieService().getAllSeries(
            apikey,
            "pt",
            "1"
        ).results

        val list: MutableList<Serie> = mutableListOf()

        a.map {
           list.add(mapperServiceSerieToSerie(it))
        }

        return list
    }

    private fun mapperServiceSerieToSerie(serviceSerie: SerieServiceEntity): Serie {

        return Serie(
            serviceSerie.title,
            serviceSerie.id,
            serviceSerie.description,
            serviceSerie.urlImage,
            serviceSerie.originalLanguage,
            serviceSerie.originalTitle,
            serviceSerie.productionYear,
            serviceSerie.genreIds
        )
    }

    }



