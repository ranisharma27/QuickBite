package com.example.quickbite.ui.theme.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search...") },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(16.dp),

        )
        Spacer(modifier = Modifier.width(4.dp))
        IconButton(
            onClick = { /* TODO */ },
            modifier = Modifier
                .size(48.dp)
                .background(color = Color(0xFFFFC0CB), shape = RoundedCornerShape(10.dp)) // Light Pink
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Filter",
                tint = Color.White // Optional: makes icon stand out on pink
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview(){
    SearchBar()
}