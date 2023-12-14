package das.jhaman.movieapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class MovieDto(
    @SerialName("poster_path")
    val posterPath: String,
    val title: String,
    @SerialName("video")
    val isVideo: Boolean,
    @SerialName("release_date")
    val releaseDate: String,
)