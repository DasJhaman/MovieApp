package das.jhaman.movieapp.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class MoviesApi(private val httpClient: HttpClient) {


    suspend fun getPopularMovies(): Result<MoviesDto> = runCatching {
        httpClient.get("movie/popular").body()
    }

    suspend fun discoverMovies(): Result<MoviesDto> = runCatching {
        httpClient.get("discover/movie").body()
    }

    suspend fun topRatedMovies(): Result<MoviesDto> = runCatching {
        httpClient.get("movie/top_rated").body()
    }
}