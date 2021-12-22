package com.example.ministore.ui.category

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ministore.data.model.ProductCategory
import com.example.ministore.data.model.ProductItem
import com.example.ministore.data.repository.CategoryRepository
import com.example.ministore.ui.Screen
import com.example.ministore.ui.home.HomeScreen
import com.example.ministore.ui.home.HomeViewModel
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
){
    val categories : List<ProductCategory> = homeViewModel.categories
    LazyVerticalGrid(
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 8.dp),
        cells = GridCells.Fixed(2) ){
        categories.forEach {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(150.dp)
                        .padding(8.dp)
                        .clickable { navController.navigate("${Screen.CategoryProducts.route}/${it.id}") }
                    ,
                    shape = RoundedCornerShape(20.dp),
                    elevation = 8.dp,
                    backgroundColor = Color(
                        red = Random.nextInt(0, 255),
                        green = Random.nextInt(0, 255),
                        blue = Random.nextInt(0, 255)
                    )
                ){
                    Box(
                        contentAlignment = Alignment.Center
                    ){
                        Text(it.name,
                            style = MaterialTheme.typography.h3,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                        )
                    }
                }
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4 )
@Composable
fun CategoryScreenPreview() {
    val navController = rememberNavController()
    val homeViewModel = HomeViewModel(CategoryRepository())
    Surface(
        color = Color.White
    ) {

        CategoryScreen(
            navController = navController,
            homeViewModel = homeViewModel
        )
    }

}