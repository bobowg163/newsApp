package com.example.newsapp.article.prensentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.newsapp.core.domain.NewsRepository

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

    }
}