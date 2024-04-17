package com.example.moviesapi.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapi.R
import com.example.moviesapi.adapter.MainAdapter
import com.example.moviesapi.databinding.ActivityMainBinding
import com.example.moviesapi.model.MainModel
import com.example.moviesapi.util.SampleData

class MainActivity : AppCompatActivity(), OnclickLitener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NAVIGATION DRAWER
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.apply {
            //    rvMain.adapter = MainAdapter(SampleData.collections)
            rvMain.setHasFixedSize(true)
            rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            mainAdapter = MainAdapter(this@MainActivity, SampleData.collections, this@MainActivity)
            rvMain.adapter = mainAdapter
//                mainAdapter.onItemClick = {
//                val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                intent.putExtra("image",it.movieModels[])
//                startActivity(intent)
//            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onclick(position: Int, title: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Next Activity")
        builder.setMessage("Go to Next Activity?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes") { dialogInterface, which ->
            Log.d("aaa", position.toString())
            Toast.makeText(this@MainActivity, title, Toast.LENGTH_LONG).show()
        }
        builder.setNeutralButton("Cancel") { dialogInterface, which ->
            Toast.makeText(
                applicationContext,
                "clicked cancel\n operation cancel",
                Toast.LENGTH_LONG
            ).show()
        }
        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
//        val intent=Intent(this@MainActivity,....)
//        intent.putStringExtra("title",title)
//        startActivity(intent)
    }

    override fun onLikeClick(item: MainModel, position: Int) {
        TODO("Not yet implemented")
    }
}