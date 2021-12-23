package com.example.ministore.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ministore.data.viewmodel.CartViewModel
import com.example.ministore.ui.cart.CardPaymentScreen
import com.example.ministore.ui.cart.CartScreen
import com.example.ministore.ui.category.CategoryProductsScreen
import com.example.ministore.ui.category.CategoryScreen
import com.example.ministore.ui.home.HomeScreen
import com.example.ministore.ui.home.HomeViewModel
import com.example.ministore.ui.home.ProductDetailsScreen
import com.example.ministore.ui.login.LoginScreen
import com.example.ministore.ui.profile.ProfileScreen
import com.example.ministore.ui.promo.PromoScreen
import com.example.ministore.ui.register.RegisterScreen

@Composable
fun MiniStoreNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.LoginScreen.route
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ){
        composable(Screen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(
                navController, hiltViewModel<HomeViewModel>()
            )
        }
        composable(Screen.CartScreen.route){
            CartScreen(navController,hiltViewModel<CartViewModel>())
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen()
        }
        composable(Screen.CategoryScreen.route){
            CategoryScreen(navController,hiltViewModel<HomeViewModel>())
        }
        composable(Screen.PromotionScreen.route){
            PromoScreen()
        }
        composable(Screen.PaymentScreen.route){
            CardPaymentScreen(navController)
        }
        composable(
            "${Screen.ProductDetailsScreen.route}/{productId}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ){
            entry ->
            val prodID = entry.arguments?.getInt("productId")
            val product = hiltViewModel<HomeViewModel>().getProduct(prodID!!)
            ProductDetailsScreen(product, hiltViewModel<CartViewModel>(),navController)
        }
        composable(
            "${Screen.CategoryProducts.route}/{categoryId}",
            arguments = listOf(
                navArgument("categoryId") {
                    type = NavType.IntType
                }
            )
        ){
                entry ->
            val catID = entry.arguments?.getInt("categoryId")
            val productCat = hiltViewModel<HomeViewModel>().getCategory(catID!!)
            CategoryProductsScreen(productCat,navController)
        }
    }

}