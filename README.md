# MathFun

## Introduction

MathFun is an Android application designed to help first-grade students practice addition and subtraction. The app features a user-friendly interface with a playful design, making learning math enjoyable for young learners.

## Table of Contents

1. Introduction
2. App Architecture
3. Class Descriptions
4. Android Framework Concepts
5. Conclusion

## App Architecture

The MathFun application follows a simple yet effective architecture suitable for small-scale applications. The architecture includes the following main components:
- MainActivity: The main entry point of the application
- NavGraph: Manages navigation between different screens
- Screens: Composable functions representing different screens (WelcomeScreen, GameScreen, AboutScreen)

## Project Structure
The project is organized into the following structure:

```
app
├── manifests
│
├── kotlin+java
│   └── com.example.mathfun
│       ├── navigation
│       │   └── NavGraph.kt
│       │
│       ├── ui.theme
│       │
│       ├── view
│       │   ├── AboutScreen.kt
│       │   ├── GameScreen.kt
│       │   └── WelcomeScreen.kt
│       │
│       └── MainActivity.kt
└── res
    └── drawable
        └── pozadina.jpg
```

## Class Descriptions

### MainActivity
MainActivity serves as the main entry point for the application. It initializes the navigation graph and sets up the content view using Jetpack Compose.

Key Responsibilities:
-Initialize navigation
-Set up the content view

### NavGraph
NavGraph is responsible for handling the navigation between different screens in the app.

Key Responsibilities:
-Define the navigation routes
-Manage the navigation state

### WelcomeScreen
WelcomeScreen is the initial screen of the app, providing users with options to start the game or learn more about the app.

Key Responsibilities:
-Display the app name and slogan
-Navigate to GameScreen or AboutScreen based on user interaction

### GameScreen
GameScreen is where the main functionality of the app resides. It allows users to practice addition and subtraction with randomly generated tasks.

Key Responsibilities:
-Display math tasks
-Handle user input
-Keep track of the score and time left
-Provide options to start a new game or share the score

### AboutScreen
AboutScreen provides information about the app, how to use it, scoring system, and other relevant details.

Key Responsibilities:
-Display app information and usage instructions
-Navigate back to the WelcomeScreen

## Android Framework Concepts

### Activity
An Activity in Android represents a single screen with a user interface. Activities are a fundamental part of the Android app lifecycle. In MathFun, MainActivity is the primary activity that hosts the navigation and screens.

### Navigation
Navigation in Jetpack Compose is handled using the NavController and a navigation graph. It allows for seamless transitions between different composable screens.

## Conclusion
MathFun is a simple yet effective application designed to make learning math fun for first-grade students. The application leverages the power of Jetpack Compose to provide a modern and responsive user interface.
