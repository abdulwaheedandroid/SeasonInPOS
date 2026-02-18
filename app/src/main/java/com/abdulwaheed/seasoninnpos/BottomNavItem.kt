package com.abdulwaheed.seasoninnpos

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Home : BottomNavItem("Home", Icons.Default.Home, "home")
    object CashDrawer : BottomNavItem("Cash Drawer", Icons.Default.DateRange, "cashDrawer")
    object Orders : BottomNavItem("Orders", Icons.Default.FavoriteBorder, "orders")
}
