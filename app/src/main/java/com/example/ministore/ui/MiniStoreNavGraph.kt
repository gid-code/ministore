package com.example.ministore.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ministore.ui.cart.CartScreen
import com.example.ministore.ui.category.CategoryScreen
import com.example.ministore.ui.home.HomeScreen
import com.example.ministore.ui.home.HomeViewModel
import com.example.ministore.ui.login.LoginScreen
import com.example.ministore.ui.profile.ProfileScreen
import com.example.ministore.ui.promo.PromoScreen
import com.example.ministore.ui.register.RegisterScreen

@Composable
fun MiniStoreNavGraph(
    navController: NavHostController = rememberNavController(),
//    viewModel: HomeViewModel = viewModel(),
    startDestination: String = Screen.HomeScreen.route
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
            CartScreen()
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen()
        }
        composable(Screen.CategoryScreen.route){
            CategoryScreen(hiltViewModel<HomeViewModel>())
        }
        composable(Screen.PromotionScreen.route){
            PromoScreen()
        }
    }

}