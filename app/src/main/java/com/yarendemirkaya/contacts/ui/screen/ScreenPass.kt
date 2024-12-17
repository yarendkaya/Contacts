package com.yarendemirkaya.contacts.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.yarendemirkaya.contacts.data.entity.Contacts

@Composable
fun ScreenPass() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainPage(navController = navController)
        }
        composable("register") {
            RegisterPage()
        }
        composable(
            "detail/{person}",
            arguments = listOf(navArgument("person") { type = NavType.StringType })
        ) {
            val json = it.arguments?.getString("person")
            val personGson = Gson().fromJson(json, Contacts::class.java)
            DetailScreen(personGson)
        }
    }
}