package das.jhaman.movieapp.ui.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun DefaultText(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    textAlign: TextAlign = TextAlign.Start,
    modifier: Modifier = Modifier,
    style: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.bodyMedium,
    textDecoration: TextDecoration = TextDecoration.None

) {
    Text(
        text = text,
        color = color,
        textAlign = textAlign,
        modifier = modifier,
        style = style,
        textDecoration = textDecoration
    )
}