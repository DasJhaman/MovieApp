package das.jhaman.movieapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.fontFamilyResource
import moviedb.app.MR

@Composable
internal fun MovieDbAppTheme(
    content: @Composable () -> Unit
) {
    val lightColors = lightColorScheme(
        primary = md_theme_light_primary,
        onPrimary = md_theme_light_onPrimary,
        primaryContainer = md_theme_light_primaryContainer,
        onPrimaryContainer = md_theme_light_onPrimaryContainer,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        secondaryContainer = md_theme_light_secondaryContainer,
        onSecondaryContainer = md_theme_light_onSecondaryContainer,
        tertiary = md_theme_light_tertiary,
        onTertiary = md_theme_light_onTertiary,
        tertiaryContainer = md_theme_light_tertiaryContainer,
        onTertiaryContainer = md_theme_light_onTertiaryContainer,
        error = md_theme_light_error,
        onError = md_theme_light_onError,
        errorContainer = md_theme_light_errorContainer,
        onErrorContainer = md_theme_light_onErrorContainer,
        outline = md_theme_light_outline,
        background = md_theme_light_background,
        onBackground = md_theme_light_onBackground,
        surface = md_theme_light_surface,
        onSurface = md_theme_light_onSurface,
        surfaceVariant = md_theme_light_surfaceVariant,
        onSurfaceVariant = md_theme_light_onSurfaceVariant,
        inverseSurface = md_theme_light_inverseSurface,
        inverseOnSurface = md_theme_light_inverseOnSurface,
        inversePrimary = md_theme_light_inversePrimary,
        surfaceTint = md_theme_light_surfaceTint,
        outlineVariant = md_theme_light_outlineVariant,
        scrim = md_theme_light_scrim,
    )

    val typography = Typography(
        displaySmall = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        displayMedium = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ),

        headlineSmall = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.Normal,
            fontSize = 26.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.SemiBold,
            fontSize = 26.sp
        ),


        bodySmall = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        ),

        labelSmall = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        labelMedium = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        labelLarge = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.dmsansregular.dmsansregular),
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        ),
    )

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(6.dp),
        large = RoundedCornerShape(8.dp)
    )

    MaterialTheme(
        colorScheme = lightColors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
