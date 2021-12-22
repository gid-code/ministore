package com.example.ministore.data.model

data class CartItem(
    val item: ProductItem,
    val quantity: Int,
    val total: Double
)
