package com.abdulwaheed.seasoninnpos.ui.bottom_navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.abdulwaheed.seasoninnpos.R

sealed class BottomNavItem(@StringRes val title: Int, val icon: ImageVector, val route: String) {
    object Home : BottomNavItem(R.string.home, Icons.Default.Home, "home")
    object CashDrawer : BottomNavItem(R.string.cash_drawer, Icons.Default.DateRange, "cashDrawer")
    object Orders : BottomNavItem(R.string.orders, Icons.Default.FavoriteBorder, "orders")
    object Products : BottomNavItem(R.string.products, Icons.Default.FavoriteBorder, "products")
    object More : BottomNavItem(R.string.more, Icons.Default.FavoriteBorder, "more")
}