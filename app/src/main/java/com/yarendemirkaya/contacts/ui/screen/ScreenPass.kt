package com.yarendemirkaya.contacts.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.yarendemirkaya.contacts.data.entity.Contacts
import com.yarendemirkaya.contacts.ui.viewmodel.DetailViewModel
import com.yarendemirkaya.contacts.ui.viewmodel.MainPageViewModel
import com.yarendemirkaya.contacts.ui.viewmodel.RegisterViewModel

@Composable
fun ScreenPass(mainPageViewModel: MainPageViewModel,
               registerViewModel: RegisterViewModel,
               detailViewModel: DetailViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainPage(navController = navController, mainPageViewModel)
        }
        composable("register") {
            RegisterPage(registerViewModel)
        }
        composable(
            "detail/{person}",
            arguments = listOf(navArgument("person") { type = NavType.StringType })
        ) {
            val json = it.arguments?.getString("person")
            val personGson = Gson().fromJson(json, Contacts::class.java)
            DetailScreen(personGson,detailViewModel)
        }
    }
}