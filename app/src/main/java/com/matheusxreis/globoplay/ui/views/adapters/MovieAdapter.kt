package com.matheusxreis.globoplay.ui.views.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.entities.Movie
import com.squareup.picasso.Picasso
import java.net.URL

class MovieAdapter(val onImageClick: ()->Unit?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


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
        private val image = itemView.findViewById<ImageView>(R.id.item_image);

        fun bind(movie: Movie){

            image.setOnClickListener{
                    onImageClick();
            }

            title.text = movie.title
            Picasso.get().load(movie.urlImage).into(image)

            }


    }


}