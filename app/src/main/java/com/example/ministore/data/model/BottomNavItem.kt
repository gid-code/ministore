package com.example.ministore.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem (
    val route: String,
    val icon: ImageVector? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
)