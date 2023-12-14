package das.jhaman.movieapp.ui


import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import das.jhaman.movieapp.ui.theme.MovieDbAppTheme

@Composable
fun MainContent() {
    MovieDbAppTheme {
        Navigator(MainScreen())
    }
}
