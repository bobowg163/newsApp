package com.example.newsapp.core.data

import com.example.newsapp.core.domain.Article
import com.example.newsapp.core.domain.NewsList
import com.example.newsapp.core.domain.NewsRepository
import com.example.newsapp.core.domain.NewsResult
import kotlinx.coroutines.flow.Flow

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data
 * @作者 bobo
 * @日期及日间 2024/12/8 17:02
 **/
class NewsRepositoryImpl:NewsRepository {
    override suspend fun getNews(): Flow<NewsResult<NewsList>> {
        TODO("Not yet implemented")
    }

    override suspend fun paginate(nextPage: String): Flow<NewsResult<NewsList>> {
        TODO("Not yet implemented")
    }

    override suspend fun getArticle(articleId: String): Flow<NewsResult<Article>> {
        TODO("Not yet implemented")
    }
}