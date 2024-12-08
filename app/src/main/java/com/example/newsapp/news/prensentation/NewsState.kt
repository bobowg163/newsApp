package com.example.newsapp.news.prensentation

import com.example.newsapp.core.domain.Article

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.news.prensentation
 * @作者 bobo
 * @日期及日间 2024/12/8 20:37
 **/
data class NewsState(
    val articleList:List<Article> = emptyList(),
    val nextPage:String?= null,
    val isLoading:Boolean = false,
    val isError:Boolean = false,
)
