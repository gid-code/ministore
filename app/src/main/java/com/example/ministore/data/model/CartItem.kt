package com.example.ministore.data.model

data class CartItem(
    val item: ProductItem,
    var quantity: Int,
    var total: Double
)
