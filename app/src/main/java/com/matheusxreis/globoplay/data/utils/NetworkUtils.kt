package com.matheusxreis.globoplay.data.utils

import com.matheusxreis.globoplay.data.services.movies.MoviesService
import com.matheusxreis.globoplay.data.services.series.SeriesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils(path:String) {

     var  retrofit = Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    fun MovieService(): MoviesService {
       return retrofit.create(MoviesService::class.java)
    }

    fun SerieService(): SeriesService {
        return retrofit.create(SeriesService::class.java)
    }
}


