package com.example.mathfun.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mathfun.view.WelcomeScreen
import com.example.mathfun.view.GameScreen
import com.example.mathfun.view.AboutScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("game") { GameScreen(navController) }
    }
}
