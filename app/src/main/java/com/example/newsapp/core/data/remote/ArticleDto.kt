package com.example.newsapp.core.data.remote

import kotlinx.serialization.Serializable

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data.remote
 * @作者 bobo
 * @日期及日间 2024/12/8 16:04
 **/

@Serializable
data class ArticleDto(
    val article_id: String?,
    val title: String?,
    val description: String?,
    val content: String?,
    val pubDate: String?,
    val source_name: String?,
    val image_url: String?
)