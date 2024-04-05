package com.example.moviesapi.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapi.adapter.MainAdapter
import com.example.moviesapi.databinding.ActivityMainBinding
import com.example.moviesapi.util.SampleData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvMain.adapter = MainAdapter(SampleData.collections)
        }


    }
}