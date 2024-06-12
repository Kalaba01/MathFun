package com.example.mathfun.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mathfun.R

@Composable
fun AboutScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pozadina),
            contentDescription = null,
            alpha = 0.5F,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        if (isPortrait) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text(
                        text = "About",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "This app is designed to help first grade students practice addition and subtraction.",
                        fontSize = 20.sp,

                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Usage:", )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "1. Press 'Start Game' to begin the exercise.", )
                    Text(text = "2. Answer the questions as quickly as possible.", )
                    Text(text = "3. Use 'New Game' to restart the game at any time.", )
                    Text(text = "4. Share your score with friends using the 'Share' button.", )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Scoring:", )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = " - Correct answer: +5 points", )
                    Text(text = " - Incorrect answer: -3 points", )
                    Text(text = " - Time limit: 60 seconds", )
                }
                Button(
                    onClick = { navController.navigate("welcome") },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Home", color = Color.Black)
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text(
                        text = "About",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "This app is designed to help first grade students practice addition and subtraction.",
                        fontSize = 20.sp,

                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Usage:", )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "1. Press 'Start Game' to begin the exercise.", )
                    Text(text = "2. Answer the questions as quickly as possible.", )
                    Text(text = "3. Use 'New Game' to restart the game at any time.", )
                    Text(text = "4. Share your score with friends using the 'Share' button.", )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Scoring:", )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = " - Correct answer: +5 points", )
                    Text(text = " - Incorrect answer: -3 points", )
                    Text(text = " - Time limit: 60 seconds", )
                }
                Button(
                    onClick = { navController.navigate("welcome") },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Home", color = Color.Black)
                }
            }
        }
    }
}
