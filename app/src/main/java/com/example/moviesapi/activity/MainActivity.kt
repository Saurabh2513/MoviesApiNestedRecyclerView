package com.example.moviesapi.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapi.adapter.MainAdapter
import com.example.moviesapi.adapter.MovieAdapter
import com.example.moviesapi.databinding.ActivityMainBinding
import com.example.moviesapi.util.SampleData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var mainAdapter: MainAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.apply {
            //    rvMain.adapter = MainAdapter(SampleData.collections)
            rvMain.setHasFixedSize(true)
            rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            mainAdapter = MainAdapter(this@MainActivity,SampleData.collections)
            rvMain.adapter = mainAdapter

//            mainAdapter.onItemClick = {
//                val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                intent.putExtra("image",it.movieModels[])
//                startActivity(intent)
//            }


        }


    }
}