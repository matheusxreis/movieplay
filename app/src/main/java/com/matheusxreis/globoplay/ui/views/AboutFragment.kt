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
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.services.MoviesService
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation


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

        var titleMovie: TextView = view.findViewById(R.id.title_movie);
        var genMovie: TextView = view.findViewById(R.id.gen_movie);
        var description: TextView = view.findViewById(R.id.description_movie)

        var movieId = args.movieId

        val movie:Movie? = getMovieInfoById(movieId)

        if(movie != null){
            setImageURLByUrl(image, movie.urlImage)
          //  setImageURLByUrl(imageBg, movie.urlImage)
            setImageBlurByUrl(movie.urlImage, imageBg)
            titleMovie.text = movie.title
            genMovie.text = movie.technicalSheet.gen[0]
            description.text = movie.description

        }


    }


    override fun onStart() {
        super.onStart()

    }

    fun getMovieInfoById(id: String): Movie? = viewModel.getMovieById(id)


    fun setImageURLByUrl(image: ImageView, url:String){
            Picasso.get().load(url).into(image)

    }

    fun setImageBlurByUrl(url: String, image: ImageView?){
        if(image!= null) {
            Picasso.get()
                .load(url)
                .transform(BlurTransformation(context, 25, 4))
                .into(image)
//            Blurry.with(this.requireContext()).capture(requireView()
//            ).into(image)
        }
    }
}