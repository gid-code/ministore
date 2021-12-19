package com.example.ministore.ui.category

import android.content.res.Configuration
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ministore.data.repository.CategoryRepository
import com.example.ministore.ui.home.HomeScreen
import com.example.ministore.ui.home.HomeViewModel

@Composable

fun CategoryScreen(
    homeViewModel: HomeViewModel
){
    Text("category")
}

@Preview(backgroundColor = 0xFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4 )
@Composable
fun CategoryScreenPreview() {
    val homeViewModel = HomeViewModel(CategoryRepository())
    Surface(
        color = Color.White
    ) {

        CategoryScreen(
            homeViewModel = homeViewModel
        )
    }

}