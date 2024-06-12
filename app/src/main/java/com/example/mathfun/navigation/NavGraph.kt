package com.example.mathfun.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mathfun.view.WelcomeScreen
import com.example.mathfun.view.GameScreen
import com.example.mathfun.view.AboutScreen

//sealed class Screen(val route: String) {
//    object Welcome : Screen("welcome_screen")
//    object Game : Screen("game_screen")
//    object About : Screen("about_screen")
//}

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("game") { GameScreen(navController) }
    }
}
