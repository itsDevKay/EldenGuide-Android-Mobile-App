package com.example.helloworld

import android.app.Activity
import android.app.AlertDialog
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helloworld.components.Actions
import com.example.helloworld.components.Destinations
import com.example.helloworld.screens.Favorites
import com.example.helloworld.screens.Home
import com.example.helloworld.ui.theme.HelloWorldTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    var alertDialog: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WindowInsetsControllerCompat(
                window,
                window.decorView
            ).isAppearanceLightStatusBars = false
            val systemUiController = rememberSystemUiController()
            if(isSystemInDarkTheme()) {
                systemUiController.setSystemBarsColor(
                    color = Color(0xff15140e)
                )
            } else {
                systemUiController.setSystemBarsColor(
                    color = Color(0xff15140e)
                )
            }

            val activity = (LocalContext.current as Activity)
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT

            HelloWorldTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight(),
                    topBar = {
                        Box(
                            modifier = Modifier.background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xff16150e),
                                    )
                                )
                            )
                        )
                    },
                    bottomBar = {
                        Box(modifier = Modifier.background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xff514d41)
                                )
                            )
                        ))
                    }
                ) { innerPadding ->
                    EldenRingApp(padding = innerPadding)
                }
            }
        }
    }
}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            topBar = {
                Box(
                    modifier = Modifier.background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xff16150e),
                            )
                        )
                    )
                )
            },
            bottomBar = {
                Box(modifier = Modifier.background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xff514d41)
                        )
                    )
                ))
            }
        ) { innerPadding ->
            EldenRingApp(padding = innerPadding)
        }
    }
}

@Composable
fun EldenRingApp(padding: PaddingValues?) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController = navController, startDestination = Destinations.Home) {
        composable(Destinations.Home) {
            Home(navController = navController)
        }
        composable(Destinations.Favorites) {
            Favorites(navController = navController)
        }
//                    composable(
//                        "$TaskDetail/{$TaskId}",
//                        arguments = listOf(navArgument(TaskId) { type = NavType.IntType })
//                    ) { backStackEntry ->
//                        TaskDetailScreen(
//                            taskId = backStackEntry.arguments?.getInt(TaskId) ?: 0,
//                            navigateBack = actions.navigateBack
//                        )
//                    }
//                    composable(AddProject) {
//                        AddProjectScreen(
//                            mainViewModel = mainViewModel,
//                            navigateBack = actions.navigateBack
//                        )
//                    }
//                    composable(AddTask) {
//                        AddTaskScreen(
//                            mainViewModel = mainViewModel,
//                            navigateBack = actions.navigateBack
//                        )
//                    }
    }
}

