package das.jhaman.movieapp.ui.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import das.jhaman.movieapp.ui.common.DefaultText
import das.jhaman.movieapp.ui.common.rememberStadiaController
import dev.icerock.moko.resources.compose.stringResource
import moviedb.app.MR

internal object GameTab : Tab {

    @Composable
    override fun Content() {
        Scaffold {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultText(stringResource(MR.strings.tab_game))
            }
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(rememberStadiaController())
            val title = stringResource(MR.strings.tab_game)
            return remember {
                TabOptions(index = 0u, title = title, icon = icon)
            }
        }
}