package com.example.quickbite.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quickbite.data.CartViewModel
import com.example.quickbite.data.Cartitem


@Composable
fun ProductDetailsScreen(
    navController: NavHostController,
    image: Int,
    description: String,
    name: String,
    price: Double,
    cartViewModel: CartViewModel
)
 {
    val pastelBackground = Color(0xFFFFF7E8) // soft cream
    val pastelCard = Color(0xFFFFD6E8)       // pastel pink
    val pastelButton = Color(0xFFC5FAD5)     // pastel mint
    val textColor = Color(0xFF6D597A)        // soft gray-purple

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(pastelBackground)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header text
        Text(
            text = "Product Description",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Product image
        Image(
            painter = painterResource(id = image),
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp) // Increased height for a bigger image
                .clip(RoundedCornerShape(16.dp)), // Slightly less rounding so more of the image shows
            contentScale = ContentScale.Fit // Shows full image without cropping
        )

        Spacer(modifier = Modifier.height(24.dp)) // extra gap below image

        // Description card
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = pastelCard),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = description,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Add to Cart button
        Button(
            onClick = { val item = Cartitem(
                name = name,
                imageRes = image,
                price = price,
                quantity = 1,
            )
                cartViewModel.addItem(item) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC8DD)), // pastel pink
            shape = RoundedCornerShape(50),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.7f)
        ) {
            Text(
                "Add to Cart",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

// Back button
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = pastelButton),
            shape = RoundedCornerShape(50),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.7f)
        ) {
            Text(
                "Go Back",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }

    }
}

