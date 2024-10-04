package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model.NewsModel
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val repository: NewsRepository):ViewModel(){

    private val _news = MutableStateFlow<List<NewsModel>>(emptyList())
    val news = _news.asStateFlow()

    init {
     fetchNews()
    }

    private fun  fetchNews(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getNews()
                _news.value = result ?: emptyList()
            }
        }
    }

}