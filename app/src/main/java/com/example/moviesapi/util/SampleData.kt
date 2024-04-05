package com.example.moviesapi.util

import com.example.moviesapi.model.MainModel
import com.example.moviesapi.model.MovieModel


object SampleData {

    private val movieModel= listOf(
        MovieModel(Images.imageUrl0),
        MovieModel(Images.imageUrl1),
        MovieModel(Images.imageUrl2),
        MovieModel(Images.imageUrl3),
        MovieModel(Images.imageUrl4),
        MovieModel(Images.imageUrl5),
        MovieModel(Images.imageUrl6),
        MovieModel(Images.imageUrl7),
        MovieModel(Images.imageUrl8),
        MovieModel(Images.imageUrl9)
    )

    val collections = listOf(
        MainModel("All Movie" , movieModel),
        MainModel("Want to see" , movieModel.reversed()),
        MainModel("Popular Movie" , movieModel.shuffled()),
        MainModel("Top Rated Movie" , movieModel)

    )
}