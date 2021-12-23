package com.example.ministore.data.model

import androidx.annotation.DrawableRes
import com.example.ministore.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image:Int
)

val onboardPages = listOf(
    Page(
        "Wide Range of Products",
        "Browse our catalog of products; from fashion, electronics, hair products, fitness, etc.",
        R.drawable.shopping
    ),
    Page(
        "Hassle Free Delivery",
        "No hassle, get your goods delivered to you in the comfort of your home ",
        R.drawable.delivery
    ),
    Page(
        "Secure",
        "Secure Payment.Your data is not shared with any third party.",
        R.drawable.payments
    )
)
