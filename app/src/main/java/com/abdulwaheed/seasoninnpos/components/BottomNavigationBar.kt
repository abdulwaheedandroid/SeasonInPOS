package com.abdulwaheed.seasoninnpos.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abdulwaheed.seasoninnpos.ui.bottom_navigation.BottomNavItem
import com.abdulwaheed.seasoninnpos.ui.bottom_navigation.cashdrawer_tab.CashDrawerUI
import com.abdulwaheed.seasoninnpos.ui.bottom_navigation.home_tab.HomeUI
import com.abdulwaheed.seasoninnpos.ui.bottom_navigation.more_tab.MoreUI
import com.abdulwaheed.seasoninnpos.ui.bottom_navigation.orders_tab.OrdersUI
import com.abdulwaheed.seasoninnpos.ui.bottom_navigation.products_tab.ProductsUI


@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(
                selectedRoute = currentRoute(navController),
                onItemSelected = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(padding)
        ) {

            composable(BottomNavItem.Home.route) {
                HomeUI()
            }

            composable(BottomNavItem.CashDrawer.route) {
                CashDrawerUI()
            }
            composable(BottomNavItem.Orders.route) {
                OrdersUI()
            }
            composable(BottomNavItem.Products.route) {
                ProductsUI()
            }
            composable(BottomNavItem.More.route) {
                MoreUI()
            }
        }
    }
}

@Composable
fun BottomBar(
    selectedRoute: String?,
    onItemSelected: (String) -> Unit
) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.CashDrawer,
        BottomNavItem.Orders,
        BottomNavItem.Products,
        BottomNavItem.More,
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = selectedRoute == item.route,
                onClick = { onItemSelected(item.route) },
                icon = { Icon(item.icon, contentDescription = item.route) },
                label = {
                    Text(
                        stringResource(item.title),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}




