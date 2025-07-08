package com.example.quickbite.ui.theme.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quickbite.R
import com.example.quickbite.data.CartViewModel
import com.example.quickbite.ui.theme.screen.components.BottomBar
import com.example.quickbite.ui.theme.screen.components.BottomBar2
import com.example.quickbite.ui.theme.screen.components.CartContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController,cartViewModel: CartViewModel) {
    val totalPrice = cartViewModel.getTotalPrice()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "My Cart",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 28.sp)
                    )
                },
                actions = {
                    IconButton(onClick = { navController.navigate("menu") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "Close"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomBar2(navController,totalPrice = totalPrice)
        }
    ) { paddingValues ->
        CartContent(
            modifier = Modifier.padding(paddingValues),
            cartItems = cartViewModel.cartItems,
            onIncrease = { cartViewModel.increaseQuantity(it) },
            onDecrease = { cartViewModel.decreaseQuantity(it) },
            onClearAll = { cartViewModel.clearAll() }
        )
    }
}

