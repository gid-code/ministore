package com.example.ministore.data.repository

import com.example.ministore.data.model.ProductCategory
import com.example.ministore.data.model.products
import javax.inject.Inject

class CategoryRepository @Inject constructor(

) {
    fun getProducts(): List<ProductCategory> = productCollection
    fun getProduct(productId: Int) = products.find { it.id == productId }!!
}

private val productCollection =listOf(
    ProductCategory(1,"Fashion", products.subList(0,4)),
    ProductCategory(2,"Electronics", products.subList(4,8)),
    ProductCategory(3,"Fitness", products.subList(8,12)),
    ProductCategory(4,"Hair Products", products.subList(12,16))
)