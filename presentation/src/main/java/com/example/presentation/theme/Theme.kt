package com.example.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.example.presentation.theme.color.ColorSet
import com.example.presentation.theme.color.CustomColors

private val LocalColors = staticCompositionLocalOf { ColorSet.CustomColorSet.lightColors }

@Composable
fun PagingWithComposeTheme(
    colorSet: ColorSet = ColorSet.CustomColorSet,
    typography: Typography = Typography,
    shapes: Shapes = Shapes,
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) colorSet.lightColors else colorSet.lightColors
        }

        darkTheme -> colorSet.darkColors
        else -> colorSet.lightColors
    }

    CompositionLocalProvider(LocalColors provides colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme.material,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

val MaterialTheme.customColorScheme: CustomColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current