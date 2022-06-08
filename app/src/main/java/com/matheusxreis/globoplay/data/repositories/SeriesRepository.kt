package com.matheusxreis.globoplay.data.repositories

import com.matheusxreis.globoplay.data.entities.Serie
import com.matheusxreis.globoplay.data.utils.Constants
import com.matheusxreis.globoplay.data.utils.NetworkUtils

class SeriesRepository() {

    suspend fun getSeries(): List<Serie>{
            return NetworkUtils(Constants.baseUrl).SerieService().getAllSeries(
                apikey,
                "pt",
                "1"
            ).results
    }


}