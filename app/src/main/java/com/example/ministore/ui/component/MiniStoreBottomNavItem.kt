package com.example.ministore.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.ministore.ui.theme.HintGray

@Composable
fun RowScope.MiniStoreBottomNavItem(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    selected: Boolean = false,
    selectedColor: Color = Color.White,
    unselectedColor: Color = Color.DarkGray,
    enabled: Boolean = true,
    onClick: () -> Unit
){
    val lineLength = animateFloatAsState(
        targetValue = if(selected) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

   BottomNavigationItem(
       selected = selected,
       onClick = onClick,
       modifier = modifier,
       enabled = enabled,
       selectedContentColor = selectedColor,
       unselectedContentColor = unselectedColor,
       icon = {
           Box(modifier = Modifier
               .fillMaxSize()
               .padding(8.dp)
               .drawBehind {
                   if(lineLength.value > 0f) {
                       drawLine(
                           color = if (selected) selectedColor
                           else unselectedColor,
                           start = Offset(
                               size.width / 2f - lineLength.value * 15.dp.toPx(),
                               size.height
                           ),
                           end = Offset(
                               size.width / 2f + lineLength.value * 15.dp.toPx(),
                               size.height
                           ),
                           strokeWidth = 2.dp.toPx(),
                           cap = StrokeCap.Round
                       )
                   }
               }
           ){
               if(icon != null) {
                   Icon(
                       imageVector = icon,
                       contentDescription = contentDescription,
                       modifier = Modifier
                           .align(Alignment.Center)
                   )
               }
           }
       }
   )
}