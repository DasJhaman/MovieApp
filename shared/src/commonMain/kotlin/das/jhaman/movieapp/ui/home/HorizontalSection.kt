package das.jhaman.movieapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import das.jhaman.movieapp.domain.models.Movies
import das.jhaman.movieapp.ui.common.DefaultText
import dev.icerock.moko.resources.compose.stringResource
import moviedb.app.MR

@Composable
fun HorizontalSection(
    modifier: Modifier = Modifier,
    movies: List<Movies>,
    sectionHeading: String,
    onItemClick: (Movies) -> Unit,
    viewAllClick: () -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth().padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DefaultText(
            text = sectionHeading,
            style = MaterialTheme.typography.titleMedium,
        )

        DefaultText(
            modifier = modifier.clickable { viewAllClick() },
            text = stringResource(MR.strings.view_all),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary
        )
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(movies.size) { index ->
            Image(
                modifier = Modifier
                    .size(width = 120.dp, height = 200.dp)
                    .clickable { onItemClick(movies[index]) },
                painter = rememberImagePainter(movies[index].posterPath),
                contentDescription = null,
            )
        }
    }
}