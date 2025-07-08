package com.example.quickbite.ui.theme.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StepIndicator() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StepCircle("1", isActive = true)
        StepCircle("2", isActive = false)
        StepCircle("3", isActive = false)
    }
}

@Composable
fun StepCircle(number: String, isActive: Boolean) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(
                color = if (isActive) Color(0xFFFF6F61) else Color.LightGray,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(number, color = Color.White)
    }
}
