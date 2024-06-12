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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mathfun.R

@Composable
fun WelcomeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pozadina),
            contentDescription = null,
            alpha = 0.6F,
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
                Text(
                    text = "MathFun",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,

                    )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "A fun way to practice math!",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,

                    )
                Spacer(modifier = Modifier.height(32.dp))
                Row {
                    Button(onClick = { navController.navigate("game") }) {
                        Text(text = "Start Game", color = Color.Black)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = { navController.navigate("about") }) {
                        Text(text = "About", color = Color.Black)
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "MathFun",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "A fun way to practice math!",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,

                        )
                }
                Spacer(modifier = Modifier.width(32.dp))
                Column {
                    Button(onClick = { navController.navigate("game") }) {
                        Text(text = "Start Game", color = Color.Black)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { navController.navigate("about") }) {
                        Text(text = "About", color = Color.Black)
                    }
                }
            }
        }
    }
}
