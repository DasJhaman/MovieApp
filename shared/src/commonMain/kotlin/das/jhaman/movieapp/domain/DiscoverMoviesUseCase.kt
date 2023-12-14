package das.jhaman.movieapp.domain

import das.jhaman.movieapp.data.repo.MoviesRepository

internal class DiscoverMoviesUseCase(private val discoverMoviesRepository: MoviesRepository) {
    suspend operator fun invoke() = discoverMoviesRepository.discoverMovies()
}