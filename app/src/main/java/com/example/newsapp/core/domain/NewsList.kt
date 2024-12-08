package com.example.newsapp.core.domain

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data.remote
 * @作者 bobo
 * @日期及日间 2024/12/8 16:05
 **/
data class NewsList(
    val nextPage: String?,
    val articles: List<Article>,
)
