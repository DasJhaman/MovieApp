package das.jhaman.movieapp.ui.newandhot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
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
import das.jhaman.movieapp.ui.common.rememberVideoLibrary
import dev.icerock.moko.resources.compose.stringResource
import moviedb.app.MR

internal object NewAndHotTab : Tab {

    @Composable
    override fun Content() {
        Scaffold {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultText(stringResource(MR.strings.tab_new_and_hot))
            }
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(rememberVideoLibrary())
            val title = stringResource(MR.strings.tab_new_and_hot)
            return remember {
                TabOptions(index = 0u, title = title, icon = icon)
            }
        }
}