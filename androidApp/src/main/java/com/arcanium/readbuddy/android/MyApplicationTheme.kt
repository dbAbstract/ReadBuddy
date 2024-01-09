package com.arcanium.readbuddy.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
            secondary = Color(0xFF03DAC5),
            tertiary = Color(0xFF3700B3)
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF242424),
            secondary = Color(0xFFF5F5F5),
            tertiary = Color(0xFF30475E),
            onPrimary = Color.White,
            primaryContainer = Color(0xFFF05454),
            onPrimaryContainer = Color.White,
            background = Color.White,
            onBackground = Color(0xFF242424)
        )
    }
    val typography = Typography(
        bodySmall = TextStyle(
            fontFamily = RobotoMonoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = RobotoMonoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = RobotoMonoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ),
        labelSmall = TextStyle(
            fontFamily = RobotoMonoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 9.sp
        ),
        titleSmall = TextStyle(
            fontSize = 24.sp,
            fontFamily = RobotoMonoFontFamily,
            fontWeight = FontWeight.SemiBold
        ),
        titleMedium = TextStyle(
            fontSize = 28.sp,
            fontFamily = RobotoMonoFontFamily,
            fontWeight = FontWeight.SemiBold
        ),
        titleLarge = TextStyle(
            fontSize = 36.sp,
            fontFamily = RobotoMonoFontFamily,
            fontWeight = FontWeight.Bold
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

private val RobotoMonoFontFamily = FontFamily(
    fonts = listOf(
        Font(resId = R.font.robotomono_regular, weight = FontWeight.Normal),
        Font(resId = R.font.robotomono_bold, weight = FontWeight.Bold),
        Font(resId = R.font.robotomono_bolditalic, weight = FontWeight.Bold),
        Font(resId = R.font.robotomono_extralight, weight = FontWeight.ExtraLight),
        Font(resId = R.font.robotomono_italic, weight = FontWeight.Normal),
        Font(resId = R.font.robotomono_semibold, weight = FontWeight.SemiBold)
    )
)