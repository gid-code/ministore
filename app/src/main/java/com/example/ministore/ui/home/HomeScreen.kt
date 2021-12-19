package com.example.ministore.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import com.example.ministore.ui.login.LoginScreen

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
){
    val products : List<ProductItem> = homeViewModel.categories.flatMap { it.products.toList() }.shuffled()
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        products.forEach {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(500.dp, 300.dp)
//                        .padding(8.dp)
                        ,
                    shape = RoundedCornerShape(20.dp),
                    elevation = 8.dp,
                    backgroundColor = Color(0XFFF4F5F7)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = it.img,
                                builder = {
                                    crossfade(true)
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(220.dp, 200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.h3,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
                        )

                        Text(
                            text = "GHS ${it.price}",
                            style = MaterialTheme.typography.subtitle1,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                            modifier = Modifier.padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 5.dp)
                        )
                    }
                    PaddingValues(12.dp)

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