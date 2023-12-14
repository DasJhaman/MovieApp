package das.jhaman.movieapp.ui.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import das.jhaman.movieapp.domain.models.Movies
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalSlider(
    modifier: Modifier = Modifier,
    size: Int,
    content: @Composable (page: Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { size })
    LaunchedEffect(key1 = pagerState) {
        while (true) {
            val nextPage = (pagerState.currentPage + 1) % size
            tween<Float>(durationMillis = 2000, easing = FastOutSlowInEasing)
            pagerState.animateScrollToPage(page = nextPage, pageOffsetFraction = 0f)
            delay(2000)
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(540.dp),
    ) {
        HorizontalPager(state = pagerState) { page ->
            content(page)
        }
        PagerIndicator(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .align(Alignment.BottomCenter),
            currentPage = pagerState.currentPage,
            totalItem = size
        )
    }

}

@Composable
fun SliderContent(movies: Movies) {
    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth,
        painter = rememberImagePainter(movies.posterPath),
        contentDescription = null
    )
}


@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    currentPage: Int,
    totalItem: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(totalItem) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(
    isSelected: Boolean,
    activeColor: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(10.dp)
            .clip(CircleShape).background(
                if (isSelected) activeColor
                else activeColor.copy(ContentAlpha.disabled)
            )
    )
}