package com.example.quickbite.ui.theme.screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BottomBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(icon = { Icon(Icons.Default.LocationOn, null) }, selected = true, onClick = { navController.navigate("Cart")})
        NavigationBarItem(icon = { Icon(Icons.Default.Home, null) }, selected = false, onClick = {navController.navigate("menu")})
        NavigationBarItem(icon = { Icon(Icons.Default.ShoppingCart, null) }, selected = false, onClick = {navController.navigate("Cart")})
        NavigationBarItem(icon = { Icon(Icons.Default.Person, null) }, selected = false, onClick = {navController.navigate("Cart")})
    }
}
