package das.jhaman.movieapp.ui.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import das.jhaman.movieapp.domain.DiscoverMoviesUseCase
import das.jhaman.movieapp.domain.PopularMoviesUseCase
import das.jhaman.movieapp.domain.TopRatedMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val popularMoviesUseCase: PopularMoviesUseCase,
    private val discoverMoviesUseCase: DiscoverMoviesUseCase,
    private val topRatedMoviesUseCase: TopRatedMoviesUseCase
    ) : ScreenModel {

    private val _uiData = MutableStateFlow(HomeScreenUIData())
    val uiData: StateFlow<HomeScreenUIData> = _uiData.asStateFlow()

    init {
        discoverMovies()
        popularMovies()
        fetchTopRatedMovies()
    }

    private fun popularMovies() {
        screenModelScope.launch {
            val result = popularMoviesUseCase().getOrNull()
            if (result != null) {
                _uiData.update { prev ->
                    prev.copy(popularMovies = result)
                }
            }
        }
    }

    private fun discoverMovies() {
        screenModelScope.launch {
            val result = discoverMoviesUseCase().getOrNull()
            if (result != null) {
                _uiData.update { prev ->
                    prev.copy(discoverMovies = result)
                }
            }
        }
    }

    private fun fetchTopRatedMovies() {
        screenModelScope.launch {
            val result = topRatedMoviesUseCase().getOrNull()
            if (result != null) {
                _uiData.update { prev ->
                    prev.copy(topRatedMovies = result)
                }
            }
        }
    }
}