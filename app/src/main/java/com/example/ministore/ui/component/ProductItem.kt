package com.example.ministore.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.ministore.data.model.ProductItem

@Composable
fun ProductItem(
    item : ProductItem,
    onClick: ()->Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(500.dp, 280.dp)
            .clickable {
                 onClick()
            }
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
                    data = item.img[0],
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
                text = item.name,
                style = MaterialTheme.typography.h3,
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
            )
            Text(
                text = "GHS ${item.price}",
                style = MaterialTheme.typography.subtitle1,
                fontSize = 18.sp,
                color = Color(0xFF525F7F),
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 5.dp)
            )
        }
        PaddingValues(12.dp)
    }
}