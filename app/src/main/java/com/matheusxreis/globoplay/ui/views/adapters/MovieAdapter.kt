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
import com.matheusxreis.globoplay.data.utils.Constants
import com.squareup.picasso.Picasso
import java.net.URL

class MovieAdapter(val onImageClick: (id:String)->Unit?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var data: List<Movie> = listOf()


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
        Log.d("here_setitems222222", data.toString())
        when(holder){
            is DataListViewHolder -> {
                holder.bind(data[position])
            }
        }
    }

    override fun getItemCount(): Int = data.size

    fun setItems(data: List<Movie>){
        Log.d("here_setitems", data.toString())
        if(this.data.isEmpty()){
            this.data = data
            notifyDataSetChanged()
        }

        Log.d("here_data", data.toString())

    }

    inner class DataListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val image = itemView.findViewById<ImageView>(R.id.item_image);

        fun bind(movie: Movie){

            image.setOnClickListener{
                Log.d("movie.id", movie.id)
                 onImageClick(movie.id);
            }
            Picasso.get().load(Constants.imageBaseUrl + movie.urlImage).into(image)
            Log.d("here-picasso", Constants.imageBaseUrl + movie.urlImage)
            }


    }


}