package com.matheusxreis.globoplay.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
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


    //var viewModel: ViewModel = ViewModelProvider(this).get(MainActivityViewModel(moviesRepository)::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view);
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_host_fragment)
        val navController: NavController? = navHostFragment?.findNavController()

        if(navController!=null) { bottomNavigationView.setupWithNavController(navController)}

    }


}