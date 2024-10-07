package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model.NewsModel
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model.Source
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.util.Constants.Companion.CUSTOM_BLACK

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    showBackButton: Boolean = false,
    onClickBackButton: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(CUSTOM_BLACK)
        ),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { onClickBackButton() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    )
}

@Composable
fun MainImagen(image:String){
    val image = rememberAsyncImagePainter(model = image)
    Image(painter = image,
        contentDescription ="",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    )
}

@Composable
fun CardNews(
    newsItem: NewsModel,
    onClick: ()-> Unit
){
   Card(
       shape = RoundedCornerShape(5.dp),
       modifier = Modifier.padding(10.dp)
           .shadow(40.dp)
           .clickable { onClick() }
   ) {
       Column {
           newsItem.urlToImage?.let { MainImagen(image = it) }
       }
       Column {
           newsItem.source.name?.let { Text(text = it) }
       }
       Column {
           newsItem.author?.let { Text(text = it) }
       }
       Column {
           newsItem.title?.let { Text(text = it, maxLines = 1) }
       }
   }
}