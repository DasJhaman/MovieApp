package das.jhaman.movieapp.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumMovieAppBar(
    title: String,
    actionButtonClick: (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        navigationIcon = {
            if (actionButtonClick != null) {
                IconButton(onClick = actionButtonClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                    )
                }
            }

        },
        title = {
            DefaultText(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
            )
        },
        scrollBehavior = scrollBehavior,
        actions = {}
    )
}