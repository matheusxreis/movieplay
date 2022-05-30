package com.matheusxreis.globoplay.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.services.MoviesService
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.matheusxreis.globoplay.ui.views.adapters.MovieAdapter



class MainFragment : Fragment() {

    lateinit var movieAdapter: MovieAdapter;
    var moviesService: MoviesService = MoviesService()
    var moviesRepository: MoviesRepository = MoviesRepository(moviesService)
    var viewModel: MainActivityViewModel = MainActivityViewModel(moviesRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);


        initRecyclerViews(this@MainFragment.requireView());
        setDataInRecyclerView();

    }


    private fun initRecyclerViews(view: View){
        //PAREI AQUI COM O SAFE ARGS //
        val action = MainFragmentDirections.actionMainFragmentToAboutFragment("id01")
        //
        this.movieAdapter = MovieAdapter{
            Navigation.findNavController(view).navigate(action);
        };

        val recyclerMovie: RecyclerView = view.findViewById(R.id.movie_list)
        recyclerMovie.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = movieAdapter
        }
    }


    private fun setDataInRecyclerView(){
        movieAdapter.setItems(viewModel.getMovies());
    }

}