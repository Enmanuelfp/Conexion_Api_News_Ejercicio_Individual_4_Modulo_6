package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.di

import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.data.ApiNews
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiNews(retrofit:Retrofit):ApiNews{
        return  retrofit.create(ApiNews::class.java)
    }


}