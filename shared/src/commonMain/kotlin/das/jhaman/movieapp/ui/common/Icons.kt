package das.jhaman.movieapp.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun rememberStadiaController(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "stadia_controller",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(7.875f, 33.25f)
                quadToRelative(-2.583f, 0f, -4.292f, -1.812f)
                quadToRelative(-1.708f, -1.813f, -1.75f, -4.23f)
                quadToRelative(0f, -0.333f, 0.042f, -0.75f)
                quadToRelative(0.042f, -0.416f, 0.125f, -0.75f)
                lineToRelative(3.5f, -14f)
                quadToRelative(0.583f, -2.166f, 2.375f, -3.583f)
                quadToRelative(1.792f, -1.417f, 4f, -1.417f)
                horizontalLineToRelative(16.25f)
                quadToRelative(2.208f, 0f, 4f, 1.417f)
                quadToRelative(1.792f, 1.417f, 2.417f, 3.583f)
                lineToRelative(3.5f, 14f)
                quadToRelative(0.083f, 0.375f, 0.146f, 0.771f)
                quadToRelative(0.062f, 0.396f, 0.062f, 0.771f)
                quadToRelative(0f, 2.458f, -1.771f, 4.229f)
                reflectiveQuadToRelative(-4.354f, 1.771f)
                quadToRelative(-1.75f, 0f, -3.229f, -0.896f)
                reflectiveQuadToRelative(-2.188f, -2.479f)
                lineToRelative(-1.166f, -2.417f)
                quadToRelative(-0.25f, -0.458f, -0.667f, -0.666f)
                quadToRelative(-0.417f, -0.209f, -0.917f, -0.209f)
                horizontalLineToRelative(-7.916f)
                quadToRelative(-0.5f, 0f, -0.917f, 0.209f)
                quadToRelative(-0.417f, 0.208f, -0.625f, 0.666f)
                lineToRelative(-1.167f, 2.417f)
                quadToRelative(-0.75f, 1.583f, -2.229f, 2.479f)
                quadToRelative(-1.479f, 0.896f, -3.229f, 0.896f)
                close()
                moveTo(8f, 30.625f)
                quadToRelative(0.875f, 0f, 1.667f, -0.458f)
                quadToRelative(0.791f, -0.459f, 1.291f, -1.417f)
                lineToRelative(1.167f, -2.375f)
                quadToRelative(0.583f, -1.125f, 1.625f, -1.771f)
                quadToRelative(1.042f, -0.646f, 2.292f, -0.646f)
                horizontalLineToRelative(7.916f)
                quadToRelative(1.209f, 0f, 2.271f, 0.667f)
                quadToRelative(1.063f, 0.667f, 1.688f, 1.75f)
                lineToRelative(1.166f, 2.375f)
                quadToRelative(0.5f, 0.958f, 1.292f, 1.417f)
                quadToRelative(0.792f, 0.458f, 1.667f, 0.458f)
                quadToRelative(1.333f, 0f, 2.396f, -0.917f)
                quadToRelative(1.062f, -0.916f, 1.104f, -2.416f)
                quadToRelative(0f, -0.209f, -0.021f, -0.459f)
                reflectiveQuadToRelative(-0.063f, -0.5f)
                lineToRelative(-3.5f, -13.958f)
                quadToRelative(-0.333f, -1.333f, -1.396f, -2.167f)
                quadToRelative(-1.062f, -0.833f, -2.437f, -0.833f)
                horizontalLineToRelative(-16.25f)
                quadToRelative(-1.375f, 0f, -2.437f, 0.833f)
                quadToRelative(-1.063f, 0.834f, -1.355f, 2.167f)
                lineToRelative(-3.5f, 13.958f)
                quadToRelative(-0.083f, 0.209f, -0.125f, 0.917f)
                quadToRelative(0f, 1.5f, 1.104f, 2.438f)
                quadToRelative(1.105f, 0.937f, 2.438f, 0.937f)
                close()
                moveToRelative(14.5f, -12.667f)
                quadToRelative(-0.542f, 0f, -0.917f, -0.375f)
                reflectiveQuadToRelative(-0.375f, -0.916f)
                quadToRelative(0f, -0.542f, 0.375f, -0.938f)
                quadToRelative(0.375f, -0.396f, 0.917f, -0.396f)
                reflectiveQuadToRelative(0.938f, 0.396f)
                quadToRelative(0.395f, 0.396f, 0.395f, 0.938f)
                quadToRelative(0f, 0.541f, -0.395f, 0.916f)
                quadToRelative(-0.396f, 0.375f, -0.938f, 0.375f)
                close()
                moveToRelative(3.333f, -3.333f)
                quadToRelative(-0.541f, 0f, -0.916f, -0.375f)
                reflectiveQuadToRelative(-0.375f, -0.917f)
                quadToRelative(0f, -0.541f, 0.375f, -0.937f)
                reflectiveQuadToRelative(0.916f, -0.396f)
                quadToRelative(0.542f, 0f, 0.938f, 0.396f)
                quadToRelative(0.396f, 0.396f, 0.396f, 0.937f)
                quadToRelative(0f, 0.542f, -0.396f, 0.917f)
                reflectiveQuadToRelative(-0.938f, 0.375f)
                close()
                moveToRelative(0f, 6.667f)
                quadToRelative(-0.541f, 0f, -0.916f, -0.375f)
                reflectiveQuadTo(24.542f, 20f)
                quadToRelative(0f, -0.542f, 0.375f, -0.938f)
                quadToRelative(0.375f, -0.395f, 0.916f, -0.395f)
                quadToRelative(0.542f, 0f, 0.938f, 0.395f)
                quadToRelative(0.396f, 0.396f, 0.396f, 0.938f)
                quadToRelative(0f, 0.542f, -0.396f, 0.917f)
                reflectiveQuadToRelative(-0.938f, 0.375f)
                close()
                moveToRelative(3.334f, -3.334f)
                quadToRelative(-0.542f, 0f, -0.917f, -0.375f)
                reflectiveQuadToRelative(-0.375f, -0.916f)
                quadToRelative(0f, -0.542f, 0.375f, -0.938f)
                quadToRelative(0.375f, -0.396f, 0.917f, -0.396f)
                quadToRelative(0.541f, 0f, 0.937f, 0.396f)
                reflectiveQuadToRelative(0.396f, 0.938f)
                quadToRelative(0f, 0.541f, -0.396f, 0.916f)
                reflectiveQuadToRelative(-0.937f, 0.375f)
                close()
                moveToRelative(-15f, 2.667f)
                quadToRelative(-0.417f, 0f, -0.729f, -0.313f)
                quadToRelative(-0.313f, -0.312f, -0.313f, -0.729f)
                verticalLineToRelative(-1.875f)
                horizontalLineTo(11.25f)
                quadToRelative(-0.417f, 0f, -0.729f, -0.312f)
                quadToRelative(-0.313f, -0.313f, -0.313f, -0.729f)
                quadToRelative(0f, -0.417f, 0.313f, -0.75f)
                quadToRelative(0.312f, -0.334f, 0.729f, -0.334f)
                horizontalLineToRelative(1.875f)
                verticalLineTo(13.75f)
                quadToRelative(0f, -0.417f, 0.313f, -0.75f)
                quadToRelative(0.312f, -0.333f, 0.729f, -0.333f)
                quadToRelative(0.416f, 0f, 0.75f, 0.333f)
                quadToRelative(0.333f, 0.333f, 0.333f, 0.75f)
                verticalLineToRelative(1.833f)
                horizontalLineToRelative(1.833f)
                quadToRelative(0.417f, 0f, 0.75f, 0.334f)
                quadToRelative(0.334f, 0.333f, 0.334f, 0.75f)
                quadToRelative(0f, 0.416f, -0.334f, 0.729f)
                quadToRelative(-0.333f, 0.312f, -0.75f, 0.312f)
                horizontalLineTo(15.25f)
                verticalLineToRelative(1.875f)
                quadToRelative(0f, 0.417f, -0.333f, 0.729f)
                quadToRelative(-0.334f, 0.313f, -0.75f, 0.313f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberVideoLibrary(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "video_library",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20.458f, 21.5f)
                lineTo(26f, 17.917f)
                quadToRelative(0.542f, -0.334f, 0.542f, -0.959f)
                reflectiveQuadToRelative(-0.542f, -1f)
                lineToRelative(-5.542f, -3.541f)
                quadToRelative(-0.625f, -0.375f, -1.229f, -0.042f)
                quadToRelative(-0.604f, 0.333f, -0.604f, 1f)
                verticalLineTo(20.5f)
                quadToRelative(0f, 0.75f, 0.604f, 1.083f)
                quadToRelative(0.604f, 0.334f, 1.229f, -0.083f)
                close()
                moveToRelative(-7.75f, 7.333f)
                quadToRelative(-1f, 0f, -1.687f, -0.687f)
                quadToRelative(-0.688f, -0.688f, -0.688f, -1.688f)
                verticalLineTo(7.5f)
                quadToRelative(0f, -1f, 0.688f, -1.688f)
                quadToRelative(0.687f, -0.687f, 1.687f, -0.687f)
                horizontalLineToRelative(18.959f)
                quadToRelative(1f, 0f, 1.687f, 0.687f)
                quadToRelative(0.688f, 0.688f, 0.688f, 1.688f)
                verticalLineToRelative(18.958f)
                quadToRelative(0f, 1f, -0.688f, 1.688f)
                quadToRelative(-0.687f, 0.687f, -1.687f, 0.687f)
                close()
                moveToRelative(0f, -1.333f)
                horizontalLineToRelative(18.959f)
                quadToRelative(0.458f, 0f, 0.75f, -0.292f)
                quadToRelative(0.291f, -0.291f, 0.291f, -0.75f)
                verticalLineTo(7.5f)
                quadToRelative(0f, -0.458f, -0.291f, -0.75f)
                quadToRelative(-0.292f, -0.292f, -0.75f, -0.292f)
                horizontalLineTo(12.708f)
                quadToRelative(-0.458f, 0f, -0.75f, 0.292f)
                quadToRelative(-0.291f, 0.292f, -0.291f, 0.75f)
                verticalLineToRelative(18.958f)
                quadToRelative(0f, 0.459f, 0.291f, 0.75f)
                quadToRelative(0.292f, 0.292f, 0.75f, 0.292f)
                close()
                moveToRelative(-4.375f, 5.708f)
                quadToRelative(-1f, 0f, -1.687f, -0.687f)
                quadToRelative(-0.688f, -0.688f, -0.688f, -1.688f)
                verticalLineTo(11.167f)
                quadToRelative(0f, -0.25f, 0.188f, -0.459f)
                quadToRelative(0.187f, -0.208f, 0.479f, -0.208f)
                reflectiveQuadToRelative(0.479f, 0.208f)
                quadToRelative(0.188f, 0.209f, 0.188f, 0.459f)
                verticalLineToRelative(19.666f)
                quadToRelative(0f, 0.459f, 0.291f, 0.75f)
                quadToRelative(0.292f, 0.292f, 0.75f, 0.292f)
                horizontalLineTo(28f)
                quadToRelative(0.25f, 0f, 0.458f, 0.187f)
                quadToRelative(0.209f, 0.188f, 0.209f, 0.48f)
                quadToRelative(0f, 0.291f, -0.209f, 0.479f)
                quadToRelative(-0.208f, 0.187f, -0.458f, 0.187f)
                close()
                moveToRelative(3.334f, -26.75f)
                verticalLineTo(27.5f)
                verticalLineTo(6.458f)
                close()
            }
        }.build()
    }
}