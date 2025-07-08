package com.example.quickbite.ui.theme.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quickbite.data.Cartitem

@Composable
fun CartContent(cartItems: List<Cartitem>,
                onIncrease: (Cartitem) -> Unit,
                onDecrease: (Cartitem) -> Unit,
                onClearAll: () -> Unit,
                modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        StepIndicator()
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Order", style = MaterialTheme.typography.titleMedium)
            Text(
                "Clear all",
                color = Color(0xFFFF6F61),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { onClearAll() }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        cartItems.forEach { item ->
            CartItem(
                name = item.name,
                price = String.format("%.2f", item.price),
                quantity = item.quantity,
                imageRes = item.imageRes,
                onIncrease = { onIncrease(item) },
                onDecrease = { onDecrease(item) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Don’t Forget 😊", style = MaterialTheme.typography.titleMedium)
    }
}

