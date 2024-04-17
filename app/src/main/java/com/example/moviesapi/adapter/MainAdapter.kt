package com.example.moviesapi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapi.R
import com.example.moviesapi.activity.DetailActivity
import com.example.moviesapi.activity.OnclickLitener
import com.example.moviesapi.databinding.ParentItemBinding
import com.example.moviesapi.model.MainModel

class MainAdapter(
    private val context: Context,
    private val collection: List<MainModel>,
    val onclick: OnclickLitener
) :
    RecyclerView.Adapter<MainAdapter.CollectionViewHolder>() {

    var onItemClick: ((MainModel) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val movieList = collection[position]
        val context = context
        holder.binding.apply {
            val collection = collection[position]
            tvGenreMovie.text = collection.title
            val movieAdapter = collection.movieModels?.let { MovieAdapter(it) }
            rvMovieChild.adapter = movieAdapter
            movieAdapter!!.onItemClick = {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Next Activity")
                builder.setMessage("Go to Next Activity?")
                builder.setIcon(android.R.drawable.ic_dialog_alert)

                builder.setPositiveButton("Yes") { dialogInterface, which ->
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("image", it)
                    context.startActivity(intent)
                    onItemClick?.invoke(movieList)

                }
                builder.setNeutralButton("Cancel") { dialogInterface, which ->
                    Toast.makeText(
                        context,
                        "clicked cancel\n operation cancel",
                        Toast.LENGTH_LONG
                    ).show()
                }
                builder.setNegativeButton("No") { dialogInterface, which ->
                    Toast.makeText(context, "clicked No", Toast.LENGTH_LONG).show()
                }
                val alertDialog: AlertDialog = builder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()
            }
        }

        holder.itemView.setOnClickListener {
            onclick.onclick(position, collection[position].title.toString())
            onItemClick?.invoke(movieList)
        }
//            holder.btnReadMore.setOnClickListener {
//            oncilck.onclick(position,collection[position].title.toString())
//            onItemClick?.invoke(movieList)
//        }
    }

    override fun getItemCount() = collection.size

    inner class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ParentItemBinding.bind(itemView)
    }
}
