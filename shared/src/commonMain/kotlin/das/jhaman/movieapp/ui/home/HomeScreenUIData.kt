package das.jhaman.movieapp.ui.home

import das.jhaman.movieapp.domain.models.Movies
import dev.icerock.moko.resources.ImageResource

data class HomeScreenUIData(
    val discoverMovies: List<Movies> = emptyList(),
    val popularMovies: List<Movies> = emptyList(),
    val topRatedMovies: List<Movies> = emptyList(),
)