package com.example.smproject.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smproject.R
import com.example.smproject.model.Search

class SearchMovieAdapter(val searchList: List<Search>?) : RecyclerView.Adapter<SearchMovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchMovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchMovieAdapter.ViewHolder, position: Int) {
        val searchItem = searchList?.get(position)
        holder.itemTitle.text = searchItem?.Title
        Glide.with(holder.itemImage.context)
            .load(searchItem?.Poster)
            .centerCrop()
            .into(holder.itemImage);
    }

    override fun getItemCount(): Int {
        return searchList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(
                    itemView.context,
                    searchList?.get(position)?.Title.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}