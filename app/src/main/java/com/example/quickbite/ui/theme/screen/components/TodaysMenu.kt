package com.example.quickbite.ui.theme.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
fun TodaysMenu(navController: NavHostController) {
    val menuItems = listOf(
        MenuItem("Burgers", R.drawable.img_burger,"burgerdetail"),
        MenuItem("Fries", R.drawable.fries,"fries"),
        MenuItem("Drinks", R.drawable.drink,"colddrink")
    )
    Column(Modifier.padding(16.dp)) {
        Text("Today’s Menu", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        LazyRow {
            item {
                PromoCard("Free Donut!", "For orders over \$20", R.drawable.donut,navController,"burgerdetail")
                PromoCard("Free Fries!", "For orders over \$20", R.drawable.fries,navController,"fries")
                PromoCard("Free IceCream!", "For orders over \$20", R.drawable.vanillaicecream,navController,"vanillaicecream")
            }
        }
        LazyRow{
            items(menuItems) { item ->
                CategoryCard(item.name, item.icon,navController,item.navigation)
            }
        }
    }
}

@Composable
fun PromoCard(title: String, subtitle: String, image: Int,navController: NavHostController,navigation:String) {
    Card(
        modifier = Modifier
            .size(width = 310.dp, height = 140.dp)
            .padding(8.dp)
            .clickable { navController.navigate(navigation) },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB2C8BA))
    ) {
        Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f).padding(8.dp)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(subtitle)
            }
            Image(painterResource(id = image), contentDescription = null, modifier = Modifier.size(80.dp))
        }
    }
}

@Composable
fun CategoryCard(name: String, icon: Int,navController: NavHostController,navigation:String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp)
                .clickable {  navController.navigate(navigation)},
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE09AA6) // Light pink color
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(name, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(4.dp))
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = name,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}


data class MenuItem(
    val name: String,
    val icon: Int,
    val navigation: String
)

