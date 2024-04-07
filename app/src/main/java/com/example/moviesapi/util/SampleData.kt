package com.example.moviesapi.util

import com.example.moviesapi.model.MainModel
import com.example.moviesapi.model.MovieModel


object SampleData {

    private val movieModel = listOf(
        MovieModel(Images.imageUrl0),
        MovieModel(Images.imageUrl1),
        MovieModel(Images.imageUrl2),
        MovieModel(Images.imageUrl3),
        MovieModel(Images.imageUrl4),
        MovieModel(Images.imageUrl5),
        MovieModel(Images.imageUrl6),
        MovieModel(Images.imageUrl7),
        MovieModel(Images.imageUrl8),
        MovieModel(Images.imageUrl9),
        MovieModel(Images.imageUrl10),
        MovieModel(Images.imageUrl11),
        MovieModel(Images.imageUrl12),
        MovieModel(Images.imageUrl13),
        MovieModel(Images.imageUrl14),
        MovieModel(Images.imageUrl15),
        MovieModel(Images.imageUrl16),
        MovieModel(Images.imageUrl17),
        MovieModel(Images.imageUrl18),
        MovieModel(Images.imageUrl19)
    )

    val collections = listOf(
        MainModel("All Movie", movieModel.shuffled()),
        MainModel("Want to see", movieModel.shuffled()),
        MainModel("Popular Movie", movieModel.shuffled()),
        MainModel("Top Rated Movie", movieModel.shuffled()),
        MainModel("New Added", movieModel.shuffled()),
        MainModel("Action", movieModel.shuffled())

    )
}