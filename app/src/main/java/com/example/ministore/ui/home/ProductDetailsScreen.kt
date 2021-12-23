package com.example.ministore.ui.home

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.ministore.R
import com.example.ministore.data.model.ProductItem
import com.example.ministore.data.repository.CategoryRepository
import com.example.ministore.data.viewmodel.CartViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ProductDetailsScreen(
    item : ProductItem,
    viewModel: CartViewModel,
    navController: NavController
){
    val scrollState = rememberScrollState()
    val inCart = remember { mutableStateOf(viewModel.inCart(item.id)) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(item.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "back button"
                        )
                    }
                }

            )
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(8.dp, 10.dp))
                .scrollable(
                    orientation = Orientation.Vertical,
                    state = scrollState
                )
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = rememberImagePainter(
                    data = item.img[0],
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Description",
                    fontSize = 22.sp,
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.W500,
                    color = Color(0xFF295BE0)
                )
                Text(
                    "GHS ${item.price}",
                    fontSize = 22.sp,
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.W500,
                    color = Color(0xFF295BE0)
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                fontSize = 18.sp,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                TextButton(
                    enabled = !inCart.value,
                    onClick={
                        if (!inCart.value){
                            viewModel.addCart(item)
                            inCart.value = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(48.dp)
                        .clip(RoundedCornerShape(20))
                        .focusable(true)
                        .background(if (inCart.value) Color.LightGray else Color(0xFF295BE0)),
                    content = {
                        AnimatedContent(
                            targetState = inCart
                        ) {  cartState ->
                            Text(if(!cartState.value) "Add to Cart" else "Item in Cart",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.h2,
                                color = Color.White
                            )
                        }

                    }
                )
                Spacer(modifier = Modifier.width(5.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(20))
                        .background(Color.LightGray),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_share_24),
                        contentDescription = "share button"
                    )
                }
            }

        }
    }
}


@Preview(backgroundColor = 0xFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4 )
@Composable
fun DetailsScreenPreview() {
    val homeViewModel = HomeViewModel(CategoryRepository())
    val cartViewModel = CartViewModel()
    val navController = rememberNavController()
    Surface(
        color = Color.White
    ) {

        ProductDetailsScreen(
            homeViewModel.getProduct(2),
            cartViewModel,
            navController
        )
    }

}