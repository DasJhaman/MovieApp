package das.jhaman.movieapp.domain.models


data class Movies(
    val posterPath: String,
    val title: String,
    val isVideo: Boolean,
    val releaseDate: String,
)
