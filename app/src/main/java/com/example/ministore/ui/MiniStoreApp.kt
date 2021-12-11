package com.example.ministore.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ministore.ui.theme.MiniStoreTheme

@Composable
fun MiniStoreApp(){
    MiniStoreTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val scaffoldState = rememberScaffoldState()
            val currentRoute = navBackStackEntry?.destination?.route ?: Screen.CartScreen.route
            Scaffold(
                scaffoldState = scaffoldState,
            ) {
                MiniStoreNavGraph(
                    navController = navController
                )
            }
        }
    }
}