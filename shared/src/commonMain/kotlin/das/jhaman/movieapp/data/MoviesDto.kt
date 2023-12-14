package das.jhaman.movieapp.data

import kotlinx.serialization.Serializable

@Serializable
data class MoviesDto(
    val page: Int,
    val results: List<MovieDto>
)
