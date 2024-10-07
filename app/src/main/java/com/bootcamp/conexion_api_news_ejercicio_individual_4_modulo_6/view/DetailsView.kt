package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.components.MainImagen
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.components.MainTopBar
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.viewModel.NewsViewModel

@Composable
fun DetailsView(viewModel: NewsViewModel, navController: NavController, id: String) {
    // Encontrar el artículo por su ID en el ViewModel
    val news by viewModel.news.collectAsState()
    val newsItem = news.find { it.source.id == id }

    Scaffold(
        topBar = {
            MainTopBar(
                title = "Details",
                showBackButton = true
            ) {
                // Al hacer clic en el botón de volver, navega hacia atrás
                navController.popBackStack()
            }
        },
        content = { paddingValues ->
            // Aquí vamos a mostrar el contenido de `newsItem` y manejar el caso de `null`
            if (newsItem != null) {
                // Si encontramos el artículo, mostramos sus detalles
                Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
                    newsItem.urlToImage?.let { MainImagen(image = it) }
                    newsItem.source.name?.let {
                        Text(text = "Source: $it", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                    newsItem.author?.let {
                        Text(text = "Author: $it", fontSize = 16.sp, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    newsItem.title?.let {
                        Text(text = it, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    newsItem.description?.let {
                        Text(text = "Description: $it", fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    newsItem.source.name?.let {
                        Text(text = "Content: $it", fontSize = 16.sp)
                    }
                }
            } else {
                // Si no encontramos el artículo, mostramos un mensaje de error
                Text(
                    text = "News not found.",
                    color = Color.Red,
                    modifier = Modifier.padding(paddingValues).padding(16.dp)
                )
            }
        }
    )
}
