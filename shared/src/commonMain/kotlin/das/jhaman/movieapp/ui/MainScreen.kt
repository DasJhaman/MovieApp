package das.jhaman.movieapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import das.jhaman.movieapp.ui.home.HomeTab
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import das.jhaman.movieapp.ui.game.GameTab
import das.jhaman.movieapp.ui.myprofile.MyProfileTab
import das.jhaman.movieapp.ui.newandhot.NewAndHotTab
import das.jhaman.movieapp.ui.util.EdgeToEdgeBottomBarState
import das.jhaman.movieapp.ui.util.rememberEdgeToEdgeBottomBarState
import kotlin.math.roundToInt


class MainScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        TabNavigator(HomeTab) {
            val localTab = LocalTabNavigator.current
            val edgeToEdgeBottomBarState = with(LocalDensity.current) {
                rememberEdgeToEdgeBottomBarState(this)
            }

            LaunchedEffect(Unit) {
                edgeToEdgeBottomBarState.bottomBarState.contentOffset = 0f
                edgeToEdgeBottomBarState.bottomBarState.heightOffset = -edgeToEdgeBottomBarState.bottomBarState.heightOffsetLimit
            }
            Scaffold(
                bottomBar = { ScrollableBottomBar(state = edgeToEdgeBottomBarState) },
            ) { innerPadding ->
                Box(Modifier.padding(innerPadding)) {
                    CurrentTab()
                }
            }
        }
    }

    @Composable
    private fun ScrollableBottomBar(state: EdgeToEdgeBottomBarState) {
        Box(
            modifier = Modifier
                .height(state.navBarHeight)
                .offset {
                    IntOffset(
                        x = 0,
                        y = (state.bottomBarState.collapsedFraction * state.initialOffsetLimitPx).roundToInt()
                    )
                }
        ) {
            NavigationBar {
                TabNavigationItem(HomeTab)
                TabNavigationItem(GameTab)
                TabNavigationItem(NewAndHotTab)
                TabNavigationItem(MyProfileTab)
            }
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        NavigationBarItem(
            icon = {
                Icon(
                    painter = tab.options.icon!!,
                    contentDescription = tab.options.title
                )
            },
            label = {
                Text(
                    text = tab.options.title,
                )
            },
            selected = tabNavigator.current == tab,
            onClick = { tabNavigator.current = tab },
            colors = NavigationBarItemDefaults
                .colors(selectedTextColor = MaterialTheme.colorScheme.primary)
        )
    }
}