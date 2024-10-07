package com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.model.NewsModel
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.repository.NewsRepository
import com.bootcamp.conexion_api_news_ejercicio_individual_4_modulo_6.state.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _news = MutableStateFlow<List<NewsModel>>(emptyList())
    val news = _news.asStateFlow()

    var state by mutableStateOf(NewsState(source = null))
        private set

    init {
        fetchNews()
    }

     private fun fetchNews() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getNews()
                Log.d("Viewmodel",result.toString())
                _news.value = result ?: emptyList()
            }
        }
    }

    fun getAllNews(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getNews()
                Log.d("Viewmodel",result.toString())
                _news.value = result?: emptyList()
            }
        }
    }

    fun getNewsById(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getNewsById(id)
                result?.let { news ->
                    state = state.copy(
                        source = news.source,
                        author = news.author ?: "",
                        title = news.title ?: "",
                        description = news.description ?: "",
                        url = news.url ?: "",
                        urlToImage = news.urlToImage ?: ""
                    )
                }
            }
        }
    }

    fun cleanNewsState() {
        state = state.copy(
            source = null,
            author = "",
            title = "",
            description = "",
            url = "",
            urlToImage = ""
        )
    }



}