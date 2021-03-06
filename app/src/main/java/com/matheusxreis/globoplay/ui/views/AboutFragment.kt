package com.matheusxreis.globoplay.ui.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.button.MaterialButton
import com.matheusxreis.globoplay.R
import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.Serie
import com.matheusxreis.globoplay.data.services.series.SerieServiceEntity
import com.matheusxreis.globoplay.data.repositories.MoviesRepository
import com.matheusxreis.globoplay.data.utils.Constants
import com.matheusxreis.globoplay.ui.viewmodels.MainActivityViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation


class AboutFragment : Fragment() {

    var moviesRepository: MoviesRepository = MoviesRepository()
   // var viewModel: MainActivityViewModel = MainActivityViewModel()

    val viewModel: MainActivityViewModel by activityViewModels()
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
        var description: TextView = view.findViewById(R.id.description_movie);


        var textOriginalTitle:TextView = view.findViewById(R.id.text_original_title);
        var textGens:TextView = view.findViewById(R.id.text_gens);
        var textProductionYear:TextView = view.findViewById(R.id.text_year_production);
        var textCountry:TextView = view.findViewById(R.id.text_country)

        var backButton:ImageButton = view.findViewById(R.id.back_button)
        var likeButton: MaterialButton = view.findViewById(R.id.favorites_button)


        var movieId = args.movieId

        val movie: Movie? = getMovieInfoById(movieId)
        val serie: Serie? = getSerieInfoById(movieId)

        if(movie != null){

            setMovieData(
                movie,
                image,
                imageBg,
                titleMovie,
                genMovie,
                description,
                textOriginalTitle,
                textGens,
                textProductionYear,
                textCountry
            )

        }
        else if(serie != null){
                setSerieData(
                    serie,
                    image,
                    imageBg,
                    titleMovie,
                    genMovie,
                    description,
                    textOriginalTitle,
                    textGens,
                    textProductionYear,
                    textCountry
                )

        }
        else{
            goBack()
        }



        backButton.setOnClickListener{
            goBack()
        }
        likeButton.setOnClickListener{
            viewModel.likeMovie(movieId)
            //falta arrumar aqui, o m??todo de like do view model
        }


    }


    override fun onStart() {
        super.onStart()

        Log.d("kokokook", "OOOOOOI")
    }

    fun setMovieData(movie: Movie,
                     image: ImageView,
                     imageBg:ImageView,
                     titleMovie:TextView,
                     genMovie:TextView,
                     description:TextView,
                     textOriginalTitle:TextView,
                     textGens:TextView,
                     textProductionYear:TextView,
                     textCountry:TextView){
        setImageURLByUrl(image, movie.urlImage)
        //  setImageURLByUrl(imageBg, movie.urlImage)
        setImageBlurByUrl(movie.urlImage, imageBg)
        titleMovie.text = movie.title
        genMovie.text = movie.title
        description.text = movie.description;

        textOriginalTitle.text = movie.originalTitle
        textGens.text = movie.title
        textProductionYear.text = movie.productionYear
        textCountry.text = movie.title
    }

    fun setSerieData(serie: Serie,
                     image: ImageView,
                     imageBg:ImageView,
                     titleMovie:TextView,
                     genMovie:TextView,
                     description:TextView,
                     textOriginalTitle:TextView,
                     textGens:TextView,
                     textProductionYear:TextView,
                     textCountry:TextView){
        setImageURLByUrl(image, serie.urlImage)
        //  setImageURLByUrl(imageBg, movie.urlImage)
        setImageBlurByUrl(serie.urlImage, imageBg)
        titleMovie.text = serie.title
        genMovie.text = serie.title
        description.text = serie.description;

        textOriginalTitle.text = serie.originalTitle
        textGens.text = serie.title
        textProductionYear.text = serie.productionYear
        textCountry.text = serie.title

    }
    fun getMovieInfoById(id: String): Movie? = viewModel.getMovieById(id)

    fun getSerieInfoById(id:String): Serie? = viewModel.getSerieById(id)

    fun setImageURLByUrl(image: ImageView, url:String){
            Picasso.get().load(Constants.imageBaseUrl+url).into(image)

    }

    fun setImageBlurByUrl(url: String, image: ImageView?){
        if(image!= null) {
            Picasso.get()
                .load(Constants.imageBaseUrl+url)
                .transform(BlurTransformation(context, 25, 4))
                .into(image)
//            Blurry.with(this.requireContext()).capture(requireView()
//            ).into(image)
        }
    }

    fun goBack(){
        val action = AboutFragmentDirections.actionAboutFragmentToMainFragment()
        Navigation.findNavController(this.requireView()).navigate(action)
    }
}