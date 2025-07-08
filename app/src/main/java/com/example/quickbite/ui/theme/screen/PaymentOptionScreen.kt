package com.example.quickbite.ui.theme.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quickbite.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentOptionScreen(navController: NavHostController) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Payment",
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
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            StepIndicator(currentStep = 3)

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentCard(
                    name = "Paytm",
                    iconRes = R.drawable.paytm,
                    isSelected = selectedOption == "Paytm",
                    onClick = { selectedOption = "Paytm" }
                )
                Spacer(modifier = Modifier.height(8.dp)) // Small gap between cards
                PaymentCard(
                    name = "PhonePe",
                    iconRes = R.drawable.phonepe,
                    isSelected = selectedOption == "PhonePe",
                    onClick = { selectedOption = "PhonePe" }
                )
                Spacer(modifier = Modifier.height(8.dp))
                PaymentCard(
                    name = "Cash on Delivery",
                    iconRes = R.drawable.cashondelivary,
                    isSelected = selectedOption == "COD",
                    onClick = { selectedOption = "COD" }
                )
            }

        }
    }
}

@Composable
fun PaymentCard(
    name: String,
    iconRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFFFFF3E0) else Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)  // This controls the height of the card
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = name,
                tint = Color.Unspecified,
                modifier = Modifier.size(50.dp)  // Smaller icon
            )
            Spacer(modifier = Modifier.width(8.dp))  // Horizontal space between icon & text
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}


