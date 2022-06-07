package com.matheusxreis.globoplay.data.repositories

import com.matheusxreis.globoplay.data.utils.Constants
import com.matheusxreis.globoplay.data.utils.NetworkUtils

class SeriesRepository() {

    suspend fun getSeries(){
            return NetworkUtils(Constants.baseUrl).MovieService().getAllSeries(
                apikey,
                "pt",
                "1"
            )
    }


}