package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.repository

import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.data.ApiNews
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model.NewsModel
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiNews: ApiNews) {

    suspend fun getNews(): List<NewsModel>? {
        val response = apiNews.getNews()
        if (response.isSuccessful){
            return response.body()?.articles
        }
        return null
    }
}