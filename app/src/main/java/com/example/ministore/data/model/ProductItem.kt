package com.example.ministore.data.model

data class ProductItem(
    val id: Int,
    val name: String,
    val desc: String,
    val img: List<String>,
    val price: Double,

)

/**
 * Static data
 */

val products = listOf(
    ProductItem(1,"Blue Jeans","ld",listOf("https://source.unsplash.com/sKgzaPTuxtw"),40.00),
    ProductItem(2,"Air Jordon","ld",listOf("https://source.unsplash.com/AqWligQpYHM"),240.00),
    ProductItem(3,"Black Converse","ld",listOf("https://source.unsplash.com/zYz41v8ks7E"),150.00),
    ProductItem(4,"Baseball Cap","ld",listOf("https://source.unsplash.com/pIQSoEYAkus"),40.00),
    ProductItem(5,"Sony Headset","ld",listOf("https://source.unsplash.com/PDX_a_82obo"),150.00),
    ProductItem(6,"Electronic Kit","ld",listOf("https://source.unsplash.com/3GZi6OpSDcY"),40.00),
    ProductItem(7,"Fujifilm Camera","ld",listOf("https://source.unsplash.com/_lSp15Z_4xk"),200.00),
    ProductItem(8,"Arduino Kit","ld",listOf("https://source.unsplash.com/gavODTHG36Y"),40.00),
    ProductItem(9,"Workout Kit","ld",listOf("https://source.unsplash.com/Y1drF0Y3Oe0"),40.00),
    ProductItem(10,"25kg Dumbbell","ld",listOf("https://source.unsplash.com/FP7cfYPPUKM"),250.00),
    ProductItem(11,"Gym Robe","ld",listOf("https://source.unsplash.com/FMQBLyhD2HU"),100.00),
    ProductItem(12,"Running Shoes","ld",listOf("https://source.unsplash.com/d3bYmnZ0ank"),80.00),
    ProductItem(13,"Ouai Oil","ld",listOf("https://source.unsplash.com/GcGV3XWEByg"),40.00),
    ProductItem(14,"FrontRow Shampoo","ld",listOf("https://source.unsplash.com/mGEVuLZNAxY"),40.00),
    ProductItem(15,"Hair Mask","ld",listOf("https://source.unsplash.com/dah-jZWgzx8"),40.00),
    ProductItem(16,"Act+","ld",listOf("https://source.unsplash.com/DuNXXPScbJM"),40.00),
//    ProductItem(1,"Blue Jeans","ld","https://source.unsplash.com/sKgzaPTuxtw","40"),
)
