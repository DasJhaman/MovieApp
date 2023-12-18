package das.jhaman.movieapp.data.repo

import das.jhaman.movieapp.data.MoviesApi
import das.jhaman.movieapp.domain.models.Movies

internal class MoviesRepository(private val moviesApi: MoviesApi) {

    suspend fun getPopularMovies(): Result<List<Movies>> =
        moviesApi.getPopularMovies().mapCatching {
            it.results.toMovies()
        }

    suspend fun discoverMovies(): Result<List<Movies>> =
        moviesApi.discoverMovies().mapCatching {
            it.results.toMovies()
        }

    suspend fun getTopRatedMovies(): Result<List<Movies>> =
        moviesApi.topRatedMovies().mapCatching {
            it.results.toMovies()
        }
}