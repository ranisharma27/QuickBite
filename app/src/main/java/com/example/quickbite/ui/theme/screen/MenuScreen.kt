package com.example.quickbite.ui.theme.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.quickbite.ui.theme.screen.components.BestOffers
import com.example.quickbite.ui.theme.screen.components.BottomBar
import com.example.quickbite.ui.theme.screen.components.GreetingSection
import com.example.quickbite.ui.theme.screen.components.SearchBar
import com.example.quickbite.ui.theme.screen.components.TodaysMenu

@Composable
fun MenuScreen(navController: NavHostController){
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            GreetingSection()
            SearchBar()
            TodaysMenu(navController)
            BestOffers(navController)
        }
    }

}
