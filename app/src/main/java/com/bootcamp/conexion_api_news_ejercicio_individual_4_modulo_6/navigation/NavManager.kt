package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.view.DetailsView
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.view.HomeView
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.viewModel.NewsViewModel

@Composable
fun NavManager(viewModel: NewsViewModel){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home"){
            HomeView(viewModel,navController)
        }

        composable("DetailsView/{id}", arguments = listOf(
        navArgument("id"){ type =NavType.StringType}
        )){
            val id = it.arguments?.getString("id") ?:""
            DetailsView(viewModel,navController,id)
        }

    }
}