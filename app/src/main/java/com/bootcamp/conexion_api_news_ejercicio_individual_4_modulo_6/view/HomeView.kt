package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.components.CardNews
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.components.MainTopBar
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.util.Constants.Companion.CUSTOM_BLACK
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.viewModel.NewsViewModel


@Composable
fun HomeView(viewModel: NewsViewModel,navController: NavController){
    Scaffold(
        topBar = {
            MainTopBar(
                title = "News US"
            ) {

            }
        }
    ) {
        ContentHomeView(viewModel,it,navController)
    }
}

@Composable
fun ContentHomeView(viewModel: NewsViewModel, paddingValues: PaddingValues,navController: NavController){
    val news by viewModel.news.collectAsState()
    LazyColumn (
        modifier = Modifier.padding(paddingValues)
            .background(Color(CUSTOM_BLACK))
    ){
        items(news){item->
            CardNews(item) {
                navController.navigate("DetailsView/${item.source.id}")
            }
//
        }
    }
}