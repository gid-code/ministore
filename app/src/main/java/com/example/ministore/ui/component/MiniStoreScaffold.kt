package com.example.ministore.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.twotone.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import com.example.ministore.data.model.BottomNavItem
import com.example.ministore.ui.Screen
import com.example.ministore.R

@Composable
fun MiniStoreScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    onFabClick: () -> Unit = {},
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = "Home"
        ),
        BottomNavItem(
            route = Screen.CategoryScreen.route,
            icon = Icons.Outlined.List,
            contentDescription = "Category"
        ),
        BottomNavItem(route = ""),
        BottomNavItem(
            route = Screen.PromotionScreen.route,
            icon = Icons.Outlined.Notifications,
            contentDescription = "Promo"
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile"
        ),
    ),
    content: @Composable () -> Unit
){
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = Color.Blue,
                    cutoutShape = CircleShape,
                    elevation = 5.dp
                ) {
                    BottomNavigation(
                        modifier = Modifier.fillMaxWidth(),
                        backgroundColor = Color.Blue,
                    ){
                        bottomNavItems.forEachIndexed { index, bottomNavItem ->
                           MiniStoreBottomNavItem(
                               icon = bottomNavItem.icon,
                               contentDescription = bottomNavItem.contentDescription,
                               selected = bottomNavItem.route == navController.currentDestination?.route,
                               enabled = bottomNavItem.icon != null
                           ) {
                               if (navController.currentDestination?.route != bottomNavItem.route) {
                                   navController.navigate(bottomNavItem.route){
                                       launchSingleTop = true
                                       restoreState = true
                                       popUpTo(findStartDestination(navController.graph).id) {
                                           saveState = true
                                       }
                                   }
                               }
                           }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = onFabClick
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = stringResource(id = R.string.open_cart)
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) {
        content()
    }
}

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

