package com.example.ministore.ui.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ministore.data.model.ProductCategory
import com.example.ministore.data.model.ProductItem
import com.example.ministore.ui.Screen
import com.example.ministore.ui.component.ProductItem

@Composable
fun CategoryProductsScreen(
    category : ProductCategory,
    navController: NavController,
){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        category.products.forEach {
            item {
                ProductItem(it) { navController.navigate("${Screen.ProductDetailsScreen.route}/${it.id}") }
            }
        }
    }

}