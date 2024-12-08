package com.example.newsapp.core.data.remote

import kotlinx.serialization.Serializable

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data.remote
 * @作者 bobo
 * @日期及日间 2024/12/8 16:05
 **/
@Serializable
data class NewsListDto(
    val nextPage: String?,
    val results: List<ArticleDto>?,
)
