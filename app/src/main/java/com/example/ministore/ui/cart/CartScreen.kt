package com.example.ministore.ui.cart

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.ministore.R
import com.example.ministore.data.repository.CategoryRepository
import com.example.ministore.data.viewmodel.CartViewModel
import com.example.ministore.ui.Screen
import com.example.ministore.ui.home.HomeViewModel
import com.example.ministore.ui.home.ProductDetailsScreen

@Composable

fun CartScreen(
    navController: NavController,
    viewModel: CartViewModel
){
    val scrollState = rememberScrollState()
    val cart = remember { mutableStateOf(viewModel.cartItems)}
    var total = 0.0
    cart.value.forEach { total += it.total }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cart") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "back button"
                        )
                    }
                }
            )
        },

    ){
        Box{
            if(cart.value.size < 1){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_baseline_remove_shopping_cart_24),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Empty Cart",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.W600
                    )
                }
            } else{
                Column(
                    modifier = Modifier
                        .verticalScroll(scrollState)
                ) {
                    cart.value.forEach {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                            ,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Image(
                                painter = rememberImagePainter(
                                    data = it.item.img[0],
                                    builder = {
                                        crossfade(true)
                                    }
                                ),
                                contentDescription = "image",
                                modifier = Modifier
                                    .size(100.dp, 100.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(
                                modifier = Modifier.align(Alignment.CenterVertically)
                            ) {
                                Text(it.item.name,
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    style = MaterialTheme.typography.h3,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W500,
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(){
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            painter = painterResource(R.drawable.ic_round_remove_circle_24),
                                            contentDescription = "remove",
                                            tint = Color.Black
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = "${it.quantity}",
                                        modifier = Modifier.align(Alignment.CenterVertically),
                                        style = MaterialTheme.typography.body2,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W500,
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            painter = painterResource(R.drawable.ic_round_add_circle_24),
                                            contentDescription = "add",
                                            tint = Color.Black
                                        )
                                    }

                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(
                                modifier = Modifier.align(Alignment.CenterVertically)
                            ) {
                                Text("GHS ${it.item.price}",
                                    style = MaterialTheme.typography.body2,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W500,
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                IconButton(onClick = {
                                    cart.value = viewModel.removeFromCart(it)
                                    println(cart.value)
//                            cart.value.remove(it)
                                }) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_round_delete_24),
                                        contentDescription = "delete",
                                        tint = Color.Black
                                    )
                                }
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total:",
                            style = MaterialTheme.typography.h3,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500,
                            color = Color.Gray
                        )
                        Text(
                            "GHS $total",
                            style = MaterialTheme.typography.h3,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500,
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))
                    TextButton(
                        onClick = {
                            navController.navigate(Screen.PaymentScreen.route)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(width = 280.dp, height = 48.dp)
                            .clip(RoundedCornerShape(20))
                            .focusable(true)
                            .background(Color(0xFF295BE0)),
                        content = {
                            Text("Proceed to Payment",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.h2,
                                color = Color.White
                            )

                        }
                    )

                    Spacer(modifier = Modifier.height(18.dp))
                }
            }

        }

    }



}

@Preview(backgroundColor = 0xFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4 )
@Composable
fun CartScreenPreview() {
    val navController = rememberNavController()
    val cartViewModel = CartViewModel()
    Surface(
        color = Color.White
    ) {

        CartScreen(
            navController,
            cartViewModel
        )
    }

}