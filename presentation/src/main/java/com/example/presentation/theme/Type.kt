package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.presentation.R

private val pretendardBold = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold)
)

private val pretendardRegular = FontFamily(
    Font(R.font.pretendard_regular, FontWeight.Normal)
)

private val pretendardThin = FontFamily(
    Font(R.font.pretendard_thin, FontWeight.Thin)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = pretendardBold,
        fontSize = 60.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = pretendardBold,
        fontSize = 32.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = pretendardBold,
        fontSize = 24.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = pretendardThin,
        fontSize = 32.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = pretendardBold,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = pretendardRegular,
        fontSize = 15.sp
    ),
    titleMedium = TextStyle(
        fontFamily = pretendardRegular,
        fontSize = 18.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = pretendardRegular,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = pretendardBold,
        fontSize = 15.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = pretendardRegular,
        fontSize = 15.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = pretendardRegular,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = pretendardBold,
        fontSize = 18.sp,
    )
)

val Typography.dialogButton: TextStyle
    @Composable get() = labelLarge.copy(
        fontSize = 18.sp
    )

val Typography.underlinedDialogButton: TextStyle
    @Composable get() = labelLarge.copy(
        textDecoration = TextDecoration.Underline
    )