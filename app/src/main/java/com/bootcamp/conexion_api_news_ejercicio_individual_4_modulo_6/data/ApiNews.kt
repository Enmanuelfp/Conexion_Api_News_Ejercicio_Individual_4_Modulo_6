package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.data

import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model.NewsModel
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model.NewsResponse
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.util.Constants.Companion.API_KEY
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiNews {
    @GET(ENDPOINT + API_KEY)
    suspend fun getNews(): Response<NewsResponse>

    @GET("${ENDPOINT}/{id}${API_KEY}")
    suspend fun getNewsById(@Path(value = "id") id: String):Response<NewsModel>
}