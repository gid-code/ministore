package com.example.ministore.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ministore.R

val MulishMedium = FontFamily(
    Font(R.font.mulish_medium, weight = FontWeight.W500),
    Font(R.font.mulish_semibold, weight = FontWeight.W600),
    Font(R.font.mulish_regular, weight = FontWeight.W400)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = MulishMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),



    defaultFontFamily = MulishMedium

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)