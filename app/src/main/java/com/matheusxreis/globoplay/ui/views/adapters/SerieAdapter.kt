package com.matheusxreis.globoplay.ui.views.adapters

import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.widget.ContentLoadingProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.entities.Serie
import com.matheusxreis.globoplay.data.utils.Constants
import com.squareup.picasso.Picasso

class SerieAdapter(val onImageClick:(id:String)->Unit?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var series: List<Serie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_holder,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is DataViewHolder -> {
                holder.bind(series[position])
            }
        }
    }

    override fun getItemCount(): Int = series.size


    fun setItems(series: List<Serie>){
            this.series = series;

            notifyDataSetChanged()
    }




    inner class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val image = itemView.findViewById<ImageView>(R.id.item_image);
        private var load = itemView.findViewById<ContentLoadingProgressBar>(R.id.loading_movie);



        fun bind(serie: Serie){

            image.setOnClickListener{
                onImageClick(serie.id)

                    Log.d("ImageClick", serie.toString())
            }
            load.visibility = View.VISIBLE;
            Picasso.get().load(Constants.imageBaseUrl + serie.urlImage).into(image);
            load.visibility = View.INVISIBLE;


        }
    }
}