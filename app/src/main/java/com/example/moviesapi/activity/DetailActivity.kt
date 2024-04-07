package com.example.moviesapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import coil.load
import com.example.moviesapi.R
import com.example.moviesapi.databinding.ActivityDetailBinding
import com.example.moviesapi.model.MainModel
import com.example.moviesapi.model.MovieModel
import com.example.moviesapi.util.Images
import com.example.moviesapi.util.SampleData

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getParcelableExtra<MovieModel>(
            "image"
        )
        if(image != null){
            val imageView : ImageView = findViewById(R.id.detailImg)
            imageView.load(image.imageUrl)

        }

    }
}