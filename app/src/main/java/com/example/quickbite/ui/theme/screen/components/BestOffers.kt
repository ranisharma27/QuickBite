package com.example.quickbite.ui.theme.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quickbite.R

@Composable
fun BestOffers(navController: NavHostController) {
    Column(Modifier.padding(8.dp).fillMaxWidth()) {
        Text("Best Offers 💕", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(Modifier.height(8.dp))
        LazyColumn {
            item {
                OfferCard("French Dog !!!", "Tasty and Spicy ", R.drawable.hotdog,navController,"hotdog")
                OfferCard("Americano latte !!!", "Creamy and tasty ", R.drawable.latte,navController,"latte")
            }
        }
    }
}

@Composable
fun OfferCard(title: String, subtitle: String, image: Int,navController: NavHostController,navigation:String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(8.dp)
            .clickable { navController.navigate(navigation) },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FFFA))
    ) {
        Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Image(painterResource(id = image), contentDescription = null, modifier = Modifier.size(80.dp))
            Column(Modifier.weight(1f).padding(8.dp)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(subtitle)
            }

        }
    }
}

