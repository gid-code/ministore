package com.example.ministore.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ministore.ui.login.LoginScreen
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
    }

}