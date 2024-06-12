package com.example.mathfun.view

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.mathfun.R

@Composable
fun GameScreen(navController: NavController) {
    var score by remember { mutableStateOf(0) }
    var timeLeft by remember { mutableStateOf(60) }
    var answer by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var number1 by remember { mutableStateOf((1..9).random()) }
    var number2 by remember { mutableStateOf((1..9).random()) }
    var operation by remember { mutableStateOf(if ((0..1).random() == 0) "+" else "-") }
    var gameRunning by remember { mutableStateOf(true) }
    val context = LocalContext.current

    fun generateTask() {
        number1 = (1..9).random()
        number2 = (1..9).random()
        operation = if ((0..1).random() == 0) "+" else "-"
        if (operation == "-" && number1 < number2) {
            val temp = number1
            number1 = number2
            number2 = temp
        }

        if (operation == "-") {
            number1 = maxOf(number1, number2)
            number2 = minOf(number1, number2)
        }
    }

    LaunchedEffect(timeLeft, gameRunning) {
        if (timeLeft > 0 && gameRunning) {
            delay(1000L)
            timeLeft--
        } else if (timeLeft == 0) {
            gameRunning = false
            message = "Time's up! Your score is $score."
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pozadina),
            contentDescription = null,
            alpha = 0.7F,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Points: $score", fontSize = 24.sp, )
                Text(text = "Time left: $timeLeft", fontSize = 24.sp, )
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (message.isNotEmpty()) {
                Text(text = message, fontSize = 18.sp, )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Text(text = "$number1 $operation $number2 =", fontSize = 32.sp, )
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = answer,
                    onValueChange = { answer = it },
                    modifier = Modifier.width(100.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    score = 0
                    timeLeft = 60
                    gameRunning = true
                    message = ""
                    generateTask()
                    answer = ""
                }, ) {
                    Text(text = "New Game", color = Color.Black)
                }
                Button(onClick = {
                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "I scored $score points in the Math Game!")
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(intent, "Share your score"))
                }, ) {
                    Text(text = "Share", color = Color.Black)
                }
                Button(onClick = {
                    if (gameRunning) {
                        if (operation == "+") {
                            if (answer == (number1 + number2).toString()) {
                                score += 5
                                message = "Correct!"
                            } else {
                                score = maxOf(0, score - 3)
                                message = "Incorrect!"
                            }
                        } else {
                            if (answer == (number1 - number2).toString()) {
                                score += 5
                                message = "Correct!"
                            } else {
                                score = maxOf(0, score - 3)
                                message = "Incorrect!"
                            }
                        }
                        generateTask()
                        answer = ""
                    }
                }, ) {
                    Text(text = "Submit", color = Color.Black)
                }
            }
        }
    }
}
