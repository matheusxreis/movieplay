package com.matheusxreis.globoplay.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.services.MoviesService
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.matheusxreis.globoplay.ui.views.adapters.MovieAdapter

class MainActivity : AppCompatActivity() {

    //
    lateinit var movieAdapter: MovieAdapter;
    var moviesService: MoviesService = MoviesService()
    var moviesRepository: MoviesRepository = MoviesRepository(moviesService)
    var viewModel: MainActivityViewModel = MainActivityViewModel(moviesRepository)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


}