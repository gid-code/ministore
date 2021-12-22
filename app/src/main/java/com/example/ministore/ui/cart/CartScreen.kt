package com.example.ministore.ui.cart

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
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
import coil.compose.rememberImagePainter
import com.example.ministore.R
import com.example.ministore.data.repository.CategoryRepository
import com.example.ministore.data.viewmodel.CartViewModel
import com.example.ministore.ui.home.HomeViewModel
import com.example.ministore.ui.home.ProductDetailsScreen

@Composable

fun CartScreen(
    viewModel: CartViewModel
){
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn{
            viewModel.cartItems.forEach {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Image(
                            painter = rememberImagePainter(
                                data = it.item.img,
                                builder = {
                                    crossfade(true)
                                }
                            ),
                            contentDescription = null,
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
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_round_delete_24),
                                    contentDescription = "delete",
                                    tint = Color.Black
                                )
                            }
                        }
                    }

                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Total:",
                style = MaterialTheme.typography.h3,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = Color.Gray
            )
            Text("GHS 900.00",
                style = MaterialTheme.typography.h3,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
            )
        }

        Spacer(modifier = Modifier.height(18.dp))
        TextButton(
            onClick = {},
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
    }


}

@Preview(backgroundColor = 0xFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4 )
@Composable
fun CartScreenPreview() {
    val cartViewModel = CartViewModel()
    Surface(
        color = Color.White
    ) {

        CartScreen(
            cartViewModel
        )
    }

}