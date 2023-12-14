package das.jhaman.movieapp

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import das.jhaman.movieapp.ui.MainContent

@Composable
fun MainView() {
    val view = LocalView.current
    val activity = LocalContext.current as ComponentActivity
    LaunchedEffect(activity, view) {
        WindowCompat.setDecorFitsSystemWindows(activity.window, false)
        WindowCompat.getInsetsController(activity.window, view).run {
            isAppearanceLightNavigationBars = false
            isAppearanceLightStatusBars = false
        }
    }
    MainContent()
}