package com.matheusxreis.globoplay.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.matheusxreis.globoplay.ui.views.adapters.MovieAdapter

class MainActivity : AppCompatActivity() {

    //
    lateinit var movieAdapter: MovieAdapter;
    var moviesRepository: MoviesRepository = MoviesRepository()
    lateinit var viewModel: MainActivityViewModel;


    //var viewModel: ViewModel = ViewModelProvider(this).get(MainActivityViewModel(moviesRepository)::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view);
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_host_fragment);
        val navHostFragment2 = supportFragmentManager.findFragmentById(R.id.secondary_host_fragment);
        val navController: NavController? = navHostFragment?.findNavController();
        val navController2: NavController? = navHostFragment2?.findNavController()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel()::class.java)

        if(navController!=null) { bottomNavigationView.setupWithNavController(navController)}
        if(navController2!=null) { bottomNavigationView.setupWithNavController(navController2)}


    }


}