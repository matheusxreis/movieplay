package com.matheusxreis.globoplay.data.services

import com.matheusxreis.globoplay.data.entities.Movie
import com.matheusxreis.globoplay.data.entities.TechnicalSheet

class MoviesService {

    val tec1 = TechnicalSheet("The Batman", listOf("Drama, Aventura"), 22, "2010", "USA", "a", "a")
    val tec2 = TechnicalSheet("I Care a Lot", listOf("Drama, Comédia"), 22, "2010", "USA", "a", "a")
    val tec3 = TechnicalSheet("Logan", listOf("Drama, Suspense"), 22, "2010", "USA", "a", "a")


    val movies: List<Movie> = listOf(
         Movie("Batman", "id01",
             "Batman segue o segundo ano de Bruce Wayne como o herói de Gotham, causando medo nos corações dos criminosos da sombria cidade.",
             "https://universoreverso.com.br/wp-content/uploads/2021/10/batman-poster-1.jpg", tec1),
         Movie("Me Importo Muito", "id02",
             " Marla Grayson (Rosamund Pike) é uma renomada guardiã legal que gosta de ficar com pessoas idosas e ricas. Às custas da última, ela leva uma confortável vida de luxo. Quando ela pensa ter encontrado uma nova vítima perfeita, " +
                     "descobre que a mesma guarda segredos perigosos. Com base nisso, Marla vai ter que usar toda sua astúcia se quiser continuar viva.",
             "https://frankmoviereviews.com/wp-content/uploads/2021/02/gKnhEsjNefpKnUdAkn7INzIFLSu.jpg", tec2),
         Movie("Logan", "id03",
             "Em 2029, Logan ganha a vida como chofer de limousine para cuidar do nonagenário Charles Xavier." +
                     " Debilitado fisicamente e esgotado emocionalmente, ele é procurado por Gabriela, " +
                     "uma mexicana que precisa da ajuda do ex-X-Men para defender a pequena Laura Kinney / X-23.",
             "https://i0.wp.com/duslerdengercege.com/wp-content/uploads/2017/03/logan-poster-2.jpg?ssl=1", tec3)
    )


    public fun getAllMovies():List<Movie> = movies;

    public fun getMovieById(id: String): Movie? {
        return movies.find { it.id === id }
    }


}