package das.jhaman.movieapp.domain

import das.jhaman.movieapp.data.repo.MoviesRepository

internal class PopularMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke() = moviesRepository.getPopularMovies()
}