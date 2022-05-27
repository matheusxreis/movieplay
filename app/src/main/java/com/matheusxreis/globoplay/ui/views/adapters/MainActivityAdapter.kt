package com.matheusxreis.globoplay.ui.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.entities.Movie

class MainActivityAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var data: List<Movie> = listOf(); private set


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return DataListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_holder,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is DataListViewHolder -> {
                holder.bind(data[position])
            }
        }
    }

    override fun getItemCount(): Int = data.size

    fun setItems(data: List<Movie>){
        this.data = data
    }

    inner class DataListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val title = itemView.findViewById<TextView>(R.id.item_title);

        fun bind(movie: Movie){
         title.text = movie.title
        }
    }


}