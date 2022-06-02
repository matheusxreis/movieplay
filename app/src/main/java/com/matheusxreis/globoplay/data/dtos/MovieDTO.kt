package com.matheusxreis.globoplay.data.dtos

data class MovieDTO(
    private val adult:Boolean,
    private val backdrop_path:String,
    private val genre_ids:List<Float>,
    private val id:Number,
    private val original_language:String,
    private val original_title:String,
    private val overview:String,
    private val popularity:Number,
    private val poster_path:String,
    private val release_date:String,
    private val title:String,
    private val video:Boolean,
    private val vote_average:Number,
    private val vote_count:Number
)
