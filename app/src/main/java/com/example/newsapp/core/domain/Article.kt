package com.example.newsapp.core.domain

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data.remote
 * @作者 bobo
 * @日期及日间 2024/12/8 16:04
 **/

data class Article(
    val articleId: String,
    val title: String,
    val description: String,
    val content: String,
    val pubDate: String,
    val sourceName: String,
    val imageUrl: String
)