package com.example.presentation.theme.color

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF355ca8)
val md_theme_light_on_primary = Color(0xFFffffff)
val md_theme_light_primary_container = Color(0xFFd7e2ff)
val md_theme_light_on_primary_container = Color(0xFF001946)
val md_theme_light_secondary = Color(0xFF006688)
val md_theme_light_on_secondary = Color(0xFFffffff)
val md_theme_light_secondary_container = Color(0xFFbee8ff)
val md_theme_light_on_secondary_container = Color(0xFF001e2b)
val md_theme_light_tertiary = Color(0xFF1160a4)
val md_theme_light_on_tertiary = Color(0xFFffffff)
val md_theme_light_tertiary_container = Color(0xFFd2e4ff)
val md_theme_light_on_tertiary_container = Color(0xFF001c39)
val md_theme_light_error = Color(0xFFB3261E)
val md_theme_light_error_container = Color(0xFFF9DEDC)
val md_theme_light_on_error = Color(0xFFFFFFFF)
val md_theme_light_on_error_container = Color(0xFF410E0B)
val md_theme_light_background = Color(0xFFFFFBFE)
val md_theme_light_on_background = Color(0xFF1C1B1F)
val md_theme_light_surface = Color(0xFFFFFBFE)
val md_theme_light_on_surface = Color(0xFF1C1B1F)
val md_theme_light_surface_variant = Color(0xFFE7E0EC)
val md_theme_light_on_surface_variant = Color(0xFF49454F)
val md_theme_light_outline = Color(0xFF79747E)
val md_theme_light_inverse_on_surface = Color(0xFFF4EFF4)
val md_theme_light_inverse_surface = Color(0xFF313033)
val md_theme_light_inverse_primary = Color(0xFFadc6ff)
val md_theme_light_shadow = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFadc6ff)
val md_theme_dark_on_primary = Color(0xFF002d6f)
val md_theme_dark_primary_container = Color(0xFF17448f)
val md_theme_dark_on_primary_container = Color(0xFFd7e2ff)
val md_theme_dark_secondary = Color(0xFF6dd2ff)
val md_theme_dark_on_secondary = Color(0xFF003549)
val md_theme_dark_secondary_container = Color(0xFF004d68)
val md_theme_dark_on_secondary_container = Color(0xFFbee8ff)
val md_theme_dark_tertiary = Color(0xFF9fc9ff)
val md_theme_dark_on_tertiary = Color(0xFF00315c)
val md_theme_dark_tertiary_container = Color(0xFF004882)
val md_theme_dark_on_tertiary_container = Color(0xFFd2e4ff)
val md_theme_dark_error = Color(0xFFF2B8B5)
val md_theme_dark_error_container = Color(0xFF8C1D18)
val md_theme_dark_on_error = Color(0xFF601410)
val md_theme_dark_on_error_container = Color(0xFFF9DEDC)
val md_theme_dark_background = Color(0xFF1C1B1F)
val md_theme_dark_on_background = Color(0xFFE6E1E5)
val md_theme_dark_surface = Color(0xFF1C1B1F)
val md_theme_dark_on_surface = Color(0xFFE6E1E5)
val md_theme_dark_surface_variant = Color(0xFF49454F)
val md_theme_dark_on_surface_variant = Color(0xFFCAC4D0)
val md_theme_dark_outline = Color(0xFF938F99)
val md_theme_dark_inverse_on_surface = Color(0xFF1C1B1F)
val md_theme_dark_inverse_surface = Color(0xFFE6E1E5)
val md_theme_dark_inverse_primary = Color(0xFF355ca8)
val md_theme_dark_shadow = Color(0xFF000000)

val seed = Color(0xFF6750A4)
val error = Color(0xFFB3261E)

sealed class ColorSet {
    open lateinit var lightColors: CustomColors
    open lateinit var darkColors: CustomColors

    data object CustomColorSet : ColorSet() {
        override var lightColors = CustomColors(
            material = lightColorScheme(
                primary = md_theme_light_primary,
                onPrimary = md_theme_light_on_primary,
                onPrimaryContainer = md_theme_light_on_primary_container,
                secondary = md_theme_light_secondary,
                onSecondary = md_theme_light_on_secondary,
                onSecondaryContainer = md_theme_light_on_secondary_container,
                surface = md_theme_light_surface,
                onSurface = md_theme_light_on_surface,
                background = md_theme_light_background,
                onBackground = md_theme_light_on_background,
                error = md_theme_light_error,
            ),
            checkedIconColor = Color.Red,
            uncheckedIconColor = Color.LightGray
        )

        override var darkColors = CustomColors(
            material = lightColorScheme(
                primary = md_theme_dark_primary,
                onPrimary = md_theme_dark_on_primary,
                onPrimaryContainer = md_theme_dark_on_primary_container,
                secondary = md_theme_dark_secondary,
                onSecondary = md_theme_dark_on_secondary,
                onSecondaryContainer = md_theme_dark_on_secondary_container,
                surface = md_theme_dark_surface,
                onSurface = md_theme_dark_on_surface,
                background = md_theme_dark_background,
                onBackground = md_theme_dark_on_background,
                error = md_theme_dark_error,
            ),
            checkedIconColor = Color.Red,
            uncheckedIconColor = Color.LightGray
        )
    }
}


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)