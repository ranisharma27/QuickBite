package com.example.quickbite.data

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickbite.R
import com.example.quickbite.ui.theme.screen.CartScreen
import com.example.quickbite.ui.theme.screen.ConfirmationScreen
import com.example.quickbite.ui.theme.screen.DetailsStepScreen
import com.example.quickbite.ui.theme.screen.MenuScreen
import com.example.quickbite.ui.theme.screen.PaymentOptionScreen
import com.example.quickbite.ui.theme.screen.ProductDetailsScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable("menu") {
            MenuScreen(navController)
        }
        composable("confirmation") {
            ConfirmationScreen(navController)
        }
        composable("cart") {
            CartScreen(navController,cartViewModel)
        }
        composable("burgerdetail") {
            ProductDetailsScreen(
                navController = navController,
                image = R.drawable.img_burger,
                description = "Sink your teeth into our delicious burger, a perfect blend of juicy, tender beef patty layered with melted cheddar cheese, crisp lettuce, fresh tomatoes, and tangy pickles. Each bite bursts with savory, smoky, and slightly sweet flavors, topped off with our signature creamy sauce. Served in a soft, toasted bun, this burger packs about 550 calories of pure delight, making it a satisfying treat for any craving!",
                name = "Burger",
                price= 50.00,
                cartViewModel = cartViewModel
            )
        }

        composable("donut") {
            ProductDetailsScreen(
                navController = navController,
                image = R.drawable.donut,
                description = "Treat yourself to this delightful donut — soft, fluffy, and glazed with a sweet, sugary coating that melts in your mouth.\n\n" +
                        "Topped with colorful sprinkles, each bite offers a perfect balance of sweetness and light vanilla flavor.\n\n" +
                        "Made with fresh dough, sugar glaze, butter, and a hint of warm spices, this donut contains around 300 calories of pure joy!",
                name = "donut",
                price= 80.00,
                cartViewModel = cartViewModel
            )
        }

        composable("fries") {
            ProductDetailsScreen(
                navController = navController,
                image = R.drawable.fries,
                description = "Enjoy our golden, crispy fries — perfectly seasoned and fried to a light, crunchy finish, with a fluffy potato center that melts in your mouth.\n\n" +
                        "Each bite delivers a savory, lightly salted flavor with just the right touch of spice for extra zing.\n\n" +
                        "Made from fresh-cut potatoes, sunflower oil, and a sprinkle of sea salt, this delicious side comes in at about 400 calories — a classic comfort food you'll love!",
                name = "Fries",
                price= 30.00,
                cartViewModel = cartViewModel
            )
        }

        composable("colddrink") {
            ProductDetailsScreen(
                navController = navController,
                image = R.drawable.drink,
                description = "Cool off with our refreshing cold drink — fizzy, sweet, and bursting with fruity flavors that tingle your taste buds with every sip.\n\n" +
                        "Served chilled with ice cubes, it’s the perfect balance of crispness and sweetness to brighten your day.\n\n" +
                        "Made with carbonated water, natural fruit extracts, and a dash of sugar, this bubbly treat has about 150 calories — light, fun, and super satisfying!",
                name = "Cold Drink",
                price= 40.00,
                cartViewModel = cartViewModel
            )
        }

        composable("hotdog") {
            ProductDetailsScreen(
                navController = navController,
                image = R.drawable.hotdog,
                description = "Savor our mouth-watering hotdog — a juicy sausage wrapped in a soft, toasted bun, topped with a drizzle of tangy mustard and ketchup for the perfect bite.\n\n" +
                        "Each bite bursts with smoky, savory goodness, complemented by a touch of sweetness and spice from the sauces.\n\n" +
                        "Made with premium sausage, fluffy bun, mustard, ketchup, and optional onions or relish, this classic snack has about 450 calories — a timeless treat you’ll love!",
                name = "HotDog",
                price= 150.00,
                cartViewModel = cartViewModel
            )
        }

        composable("vanillaicecream") {
            ProductDetailsScreen(
                navController = navController,
                image = R.drawable.vanillaicecream,
                description = "Indulge in our creamy vanilla ice cream — smooth, rich, and bursting with classic vanilla sweetness that melts in your mouth with every spoonful.\n\n" +
                        "Lightly sweet and refreshingly cool, it’s the perfect treat on a warm day or whenever you crave something delightful.\n\n" +
                        "Made with fresh milk, cream, vanilla extract, and a touch of sugar, this delicious scoop has about 200 calories — simple, pure happiness in a cup!",
                name = "Vanilla IceCream",
                price= 70.00,
                cartViewModel = cartViewModel
            )
        }

        composable("latte") {
            ProductDetailsScreen(
                navController = navController,
                image = R.drawable.latte,
                description = "Sip on our smooth Americano latte — a cozy blend of rich espresso and velvety steamed milk, with a subtle hint of natural sweetness.\n\n" +
                        "Each sip delivers a warm, comforting taste with gentle coffee notes and a creamy finish that’s perfect any time of day.\n\n" +
                        "Made with freshly brewed espresso, steamed milk, and a touch of foam, this latte contains about 120 calories — simple, satisfying, and full of flavor!",
                name = "Americano Latte",
                price= 100.00,
                cartViewModel = cartViewModel
            )
        }

        composable("detail") {
            DetailsStepScreen(navController)
        }
        composable("payment") {
            PaymentOptionScreen(navController)
        }
        // Add more screens as needed
    }
}
