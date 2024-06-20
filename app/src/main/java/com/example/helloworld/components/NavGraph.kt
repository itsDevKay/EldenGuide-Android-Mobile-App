package com.example.helloworld.components

import androidx.navigation.NavHostController

object Destinations {
    const val Home = "home"
    const val Favorites = "favorites"
    const val Map = "map"
    const val Collection = "collection"
}

class Actions(navController: NavHostController) {
//    val openTask: (Int) -> Unit = { taskId ->
//        navController.navigate("$TaskDetail/$taskId")
//    }
//    val addTask: () -> Unit = {
//        navController.navigate(AddTask)
//    }
//    val addProject: () -> Unit = {
//        navController.navigate(AddProject)
//    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}