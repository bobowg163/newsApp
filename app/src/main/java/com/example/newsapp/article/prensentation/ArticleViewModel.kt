package com.example.newsapp.article.prensentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.core.domain.NewsRepository
import com.example.newsapp.core.domain.NewsResult
import kotlinx.coroutines.launch

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.article.prensentation
 * @作者 bobo
 * @日期及日间 2024/12/9 21:48
 **/
class ArticleViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {
    var state by mutableStateOf(ArticleState())
        private set

    fun onAction(action: ArticleAction) {
        when (action) {
            is ArticleAction.LoadArticle -> getArticle(action.articleId)
        }
    }

    private fun getArticle(articleId: String) {
        if (articleId.isBlank()) {
            state = state.copy(isError = true)
            return
        }
        viewModelScope.launch {
            state = state.copy(isLong = true)
            newsRepository.getArticle(articleId).collect { newsResult ->
                state = when (newsResult) {
                    is NewsResult.Error -> {
                        state.copy(isError = true)
                    }

                    is NewsResult.Success -> {
                        state.copy(article = newsResult.data, isError = false)
                    }
                }
            }
            state = state.copy(isLong = false)
        }
    }
}