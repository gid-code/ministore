package com.example.ministore.data.model

data class ProductItem(
    val id: Int,
    val name: String,
    val desc: String,
    val img: String,
    val price: String,

)

/**
 * Static data
 */

val products = listOf(
    ProductItem(1,"Blue Jeans","ld","https://source.unsplash.com/sKgzaPTuxtw","40"),
    ProductItem(2,"Air Jordon","ld","https://source.unsplash.com/AqWligQpYHM","240"),
    ProductItem(3,"Black Converse","ld","https://source.unsplash.com/zYz41v8ks7E","150"),
    ProductItem(4,"Baseball Cap","ld","https://source.unsplash.com/pIQSoEYAkus","40"),
    ProductItem(5,"Sony Headset","ld","https://source.unsplash.com/PDX_a_82obo","150"),
    ProductItem(6,"Electronic Kit","ld","https://source.unsplash.com/3GZi6OpSDcY","40"),
    ProductItem(7,"Fujifilm Camera","ld","https://source.unsplash.com/_lSp15Z_4xk","200"),
    ProductItem(8,"Arduino Kit","ld","https://source.unsplash.com/gavODTHG36Y","40"),
    ProductItem(9,"Workout Kit","ld","https://source.unsplash.com/Y1drF0Y3Oe0","40"),
    ProductItem(10,"25kg Dumbbell","ld","https://source.unsplash.com/FP7cfYPPUKM","250"),
    ProductItem(11,"Gym Robe","ld","https://source.unsplash.com/FMQBLyhD2HU","100"),
    ProductItem(12,"Running Shoes","ld","https://source.unsplash.com/d3bYmnZ0ank","80"),
    ProductItem(13,"Ouai Oil","ld","https://source.unsplash.com/GcGV3XWEByg","40"),
    ProductItem(14,"FrontRow Shampoo","ld","https://source.unsplash.com/mGEVuLZNAxY","40"),
    ProductItem(15,"Hair Mask","ld","https://source.unsplash.com/dah-jZWgzx8","40"),
    ProductItem(16,"Act+","ld","https://source.unsplash.com/DuNXXPScbJM","40"),
//    ProductItem(1,"Blue Jeans","ld","https://source.unsplash.com/sKgzaPTuxtw","40"),
)
