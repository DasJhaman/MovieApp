package das.jhaman.movieapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import das.jhaman.movieapp.domain.models.Movies
import dev.icerock.moko.resources.compose.stringResource
import moviedb.app.MR

internal object HomeTab : Tab {

    @Composable
    override fun Content() {

        val onBoardingScreenViewModel = getScreenModel<HomeViewModel>()
        val uiData = onBoardingScreenViewModel.uiData.collectAsState()
        val local = LocalNavigator.currentOrThrow
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DashboardContentLoaded(
                    popularMovies = uiData.value.popularMovies,
                    discoverMovies = uiData.value.discoverMovies,
                    onItemClick = { movie -> },
                    viewAllClick = {} // TODO: need to add click
                )
            }
        }
    }

    @Composable
    fun DashboardContentLoaded(
        popularMovies: List<Movies>,
        discoverMovies: List<Movies>,
        onItemClick: (Movies) -> Unit,
        viewAllClick: () -> Unit
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = rememberLazyListState(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (popularMovies.isNotEmpty()) { // TODO: need to add state
                item {
                    HorizontalSlider(size = popularMovies.size) {
                        SliderContent(popularMovies[it])
                    }
                }
            }
            item {
                HorizontalSection(
                    movies = discoverMovies,
                    sectionHeading = stringResource(MR.strings.section_name_popular),
                    onItemClick = onItemClick,
                    viewAllClick = viewAllClick
                )

                HorizontalSection(
                    movies = discoverMovies,
                    sectionHeading = stringResource(MR.strings.section_name_top_rate),
                    onItemClick = onItemClick,
                    viewAllClick = viewAllClick
                )
            }
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Filled.Home)
            val title = stringResource(MR.strings.tab_home)
            return remember {
                TabOptions(index = 0u, title = title, icon = icon)
            }
        }
}

