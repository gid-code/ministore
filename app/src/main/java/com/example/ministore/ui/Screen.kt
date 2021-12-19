package com.example.ministore.ui

sealed class Screen(val route: String){
    object OnboardingScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object CartScreen : Screen("cart_screen")
    object HomeScreen : Screen( "home_screen")
    object CategoryScreen : Screen("cat_screen")
    object PromotionScreen : Screen("promo_screen")
    object ProfileScreen : Screen("profile_screen")
}
