package com.example.ministore.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.ministore.data.model.ProductCategory
import com.example.ministore.data.model.ProductItem
import com.example.ministore.data.repository.CategoryRepository
import com.example.ministore.ui.Screen
import com.example.ministore.ui.component.ProductItem
import com.example.ministore.ui.login.LoginScreen

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
){
    val products : List<ProductItem> = homeViewModel.categories.flatMap { it.products.toList() }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") }
            )
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ){
            products.forEach {
                item {
                    ProductItem(it) { navController.navigate("${Screen.ProductDetailsScreen.route}/${it.id}") }
                }
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4 )
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    val homeViewModel = HomeViewModel(CategoryRepository())
        Surface(
        color = Color.White
    ) {

        HomeScreen(
            navController = navController,
            homeViewModel = homeViewModel
        )
    }

}