package das.jhaman.movieapp.domain

import das.jhaman.movieapp.data.repo.MoviesRepository

internal class TopRatedMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke() = moviesRepository.getTopRatedMovies()
}