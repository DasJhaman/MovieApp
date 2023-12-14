package das.jhaman.movieapp.data.repo

import das.jhaman.movieapp.data.MovieDto
import das.jhaman.movieapp.domain.models.Movies
import das.jhaman.moviedbapp.BuildKonfig

internal fun MovieDto.toMovie() = Movies(
    posterPath = BuildKonfig.IMAGE_BASE_URL + posterPath,
    title = title,
    isVideo = isVideo,
    releaseDate = releaseDate
)

internal fun List<MovieDto>.toMovies() = map { it.toMovie() }