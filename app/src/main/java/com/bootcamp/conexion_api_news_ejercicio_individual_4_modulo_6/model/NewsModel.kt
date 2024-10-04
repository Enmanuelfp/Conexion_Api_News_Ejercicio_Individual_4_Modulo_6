package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model

data class NewsModel(
    val source: Source,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?
)

data class Source(
    val id: String?,
    val name: String?
)

data class NewsResponse(
    val articles: List<NewsModel>?
)


