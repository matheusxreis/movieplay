package com.matheusxreis.globoplay.ui.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.matheusxreis.globoplay.ui.views.adapters.MovieAdapter
import com.matheusxreis.globoplay.ui.views.adapters.SerieAdapter


class MainFragment : Fragment() {

    lateinit var movieAdapter: MovieAdapter;
    lateinit var serieAdapter: SerieAdapter;
    val viewModel: MainActivityViewModel by activityViewModels()


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

        //viewModel = ViewModelProvider(this.activity.).get(MainActivityViewModel()::class.java)


        initRecyclerViews(this@MainFragment.requireView());
        setDataInRecyclerView();

    }


    private fun initRecyclerViews(view: View){

        this.movieAdapter = MovieAdapter{it ->
            val action = MainFragmentDirections.actionMainFragmentToAboutFragment(it)
            Navigation.findNavController(view).navigate(action);


        };
        this.serieAdapter = SerieAdapter{
            val action = MainFragmentDirections.actionMainFragmentToAboutFragment(it)
            Navigation.findNavController(view).navigate(action);

        }

        val recyclerMovie: RecyclerView = view.findViewById(R.id.movie_list)
        recyclerMovie.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = movieAdapter
        }


        val recyclerSerie: RecyclerView = view.findViewById(R.id.serie_list)

        recyclerSerie.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = serieAdapter
        }
    }


    private fun setDataInRecyclerView(){

        viewModel.fetchMovies();
        viewModel.fetchSeries();

        viewModel.movies.observe(viewLifecycleOwner, Observer {
            Log.d("Livedata", it.toString())
             movieAdapter.setItems(it)
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.series.observe(viewLifecycleOwner, Observer {
            Log.d("ESTOU OBSERVANDO", it.toString())
            serieAdapter.setItems(it)
        })

    }

}