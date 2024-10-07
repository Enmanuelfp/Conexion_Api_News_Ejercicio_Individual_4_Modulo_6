package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.navigation.NavManager
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.ui.theme.Conexion_Api_News_Ejercicio_Individual_4_Modulo_6Theme
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.viewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: NewsViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            Conexion_Api_News_Ejercicio_Individual_4_Modulo_6Theme {
                   NavManager(viewModel)
            }
        }
    }
}


