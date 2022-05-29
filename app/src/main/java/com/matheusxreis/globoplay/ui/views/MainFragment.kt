package com.matheusxreis.globoplay.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.services.MoviesService
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.matheusxreis.globoplay.ui.views.adapters.MovieAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val action = MainFragmentDirections.actionMainFragmentToAboutFragment()
        //
        this.movieAdapter = MovieAdapter{
            Navigation.findNavController(view).navigate(R.id.actionMainFragmentToAboutFragment);
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