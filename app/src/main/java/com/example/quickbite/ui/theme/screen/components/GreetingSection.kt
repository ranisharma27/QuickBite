package com.example.quickbite.ui.theme.screen.components

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GreetingSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1E9A8))
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.DarkGray)
                    .padding(16.dp)
            ) {
                Text("R J", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text("Welcome back, Pin!", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("How Hungry are you?", color = Color.Gray,fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingSectionPreview(){
    GreetingSection()
}