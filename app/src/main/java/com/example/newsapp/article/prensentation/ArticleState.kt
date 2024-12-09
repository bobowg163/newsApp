package com.example.newsapp.article.prensentation

import com.example.newsapp.core.domain.Article

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.article.prensentation
 * @作者 bobo
 * @日期及日间 2024/12/9 21:45
 **/
data class ArticleState(
    val article: Article? = null,
    val isLong: Boolean = false,
    val isError: Boolean = false
)
