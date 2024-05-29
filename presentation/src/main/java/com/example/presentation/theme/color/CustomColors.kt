package com.example.presentation.theme.color

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val material: ColorScheme,
    val checkedIconColor: Color = Color.Red,
    val uncheckedIconColor: Color = Color.LightGray
) {
    val primary: Color get() = material.primary
    val onPrimary: Color get() = material.onPrimary
    val onPrimaryContainer: Color get() = material.onPrimaryContainer
    val secondary: Color get() = material.secondary
    val onSecondary: Color get() = material.onSecondary
    val onSecondaryContainer: Color get() = material.onSecondaryContainer
    val surface: Color get() = material.surface
    val onSurface: Color get() = material.onSurface
    val background: Color get() = material.background
    val onBackground: Color get() = material.onBackground
    val error: Color get() = material.error
}