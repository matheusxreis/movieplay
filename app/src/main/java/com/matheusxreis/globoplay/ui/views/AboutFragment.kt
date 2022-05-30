package com.matheusxreis.globoplay.ui.views

import android.graphics.BlurMaskFilter
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.services.MoviesService
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.blurry.Blurry


class AboutFragment : Fragment() {

    var moviesService: MoviesService = MoviesService()
    var moviesRepository: MoviesRepository = MoviesRepository(moviesService)
    var viewModel: MainActivityViewModel = MainActivityViewModel(moviesRepository)


    val args:AboutFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var image: ImageView = view.findViewById(R.id.photo_movie);
        var imageBg: ImageView = view.findViewById(R.id.photo_bg);

        var movieId = args.movieId

        val movie:Movie? = getMovieInfoById(movieId)

        if(movie != null){
            getImageURL(image, movie.urlImage)
            getImageURL(imageBg, movie.urlImage)

            try {
                getImageBlur(view, imageBg)
            }catch(err: Exception){
                Toast.makeText(this.context, err.toString(), Toast.LENGTH_LONG).show()

                Log.e("ERRORAQUI", err.toString())
            }
        }


    }


    override fun onStart() {
        super.onStart()

    }

    fun getMovieInfoById(id: String): Movie? = viewModel.getMovieById(id)


    fun getImageURL(image: ImageView, url:String){
            Picasso.get().load(url).into(image)

    }

    fun getImageBlur(view:View, image: ImageView?){
        if(image!= null) {
            Blurry.with(this.requireContext()).capture(requireView()
            ).into(image)
        }
    }
}