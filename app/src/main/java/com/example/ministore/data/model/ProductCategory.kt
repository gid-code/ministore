package com.example.ministore.data.model

import dagger.Provides
import javax.inject.Inject


data class ProductCategory(
    val id: Int,
    val name: String,
    val products: List<ProductItem>
)

/**
 * A fake repo
 */
//@Provides
//@Inject
//class CategoryRepo @Inject constructor() {
//    fun getProducts(): List<ProductCategory> = productCollection
//    fun getProduct(productId: Int) = products.find { it.id == productId }!!
//    fun getRelated(@Suppress("UNUSED_PARAMETER") snackId: Long) = related
//    fun getInspiredByCart() = inspiredByCart
//    fun getFilters() = filters
//    fun getPriceFilters() = priceFilters
//    fun getCart() = cart
//    fun getSortFilters() = sortFilters
//    fun getCategoryFilters() = categoryFilters
//    fun getSortDefault() = sortDefault
//    fun getLifeStyleFilters() = lifeStyleFilters
//}

