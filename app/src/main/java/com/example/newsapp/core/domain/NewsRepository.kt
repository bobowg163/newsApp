package com.example.newsapp.core.domain

import kotlinx.coroutines.flow.Flow

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.domain
 * @作者 bobo
 * @日期及日间 2024/12/8 16:14
 **/
interface NewsRepository {
    suspend fun getNews(): Flow<NewsResult<NewsList>>
    suspend fun paginate(nextPage: String?): Flow<NewsResult<NewsList>>
    suspend fun getArticle(articleId: String): Flow<NewsResult<Article>>
}