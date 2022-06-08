package com.matheusxreis.globoplay.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.matheusxreis.globoplay.ui.views.adapters.MovieAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyListFragment : Fragment() {
    lateinit var movieAdapter: MovieAdapter;
    val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);


        initRecyclerView(view);
        setDataIntoRv();

    }


    private fun initRecyclerView(view: View){
        this.movieAdapter = MovieAdapter { it -> Unit };

        val recyclerView = view.findViewById<RecyclerView>(R.id.mylist)
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
        }
    }

    private fun setDataIntoRv(){
        viewModel.fetchMovies()

        viewModel.likedMovies.observe(viewLifecycleOwner, Observer{
            movieAdapter.setItems(it)
        })

    }


}