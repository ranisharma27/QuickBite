package com.example.quickbite.ui.theme.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BottomBar2(navController: NavHostController, totalPrice: Double) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFFF6F61), shape = RoundedCornerShape(16.dp))
            .padding(vertical = 12.dp)
            .height(30.dp)
            .clickable { navController.navigate("detail") },
        contentAlignment = Alignment.Center
    ) {
        Text("Next Step  ${"%.2f".format(totalPrice)}", color = Color.White)
    }
}

