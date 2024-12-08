package com.example.newsapp.core.data

import com.example.newsapp.core.data.local.ArticlesDao
import com.example.newsapp.core.data.remote.NewsListDto
import com.example.newsapp.core.domain.Article
import com.example.newsapp.core.domain.NewsList
import com.example.newsapp.core.domain.NewsRepository
import com.example.newsapp.core.domain.NewsResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data
 * @作者 bobo
 * @日期及日间 2024/12/8 17:02
 **/
class NewsRepositoryImpl(
    private val httpClient: HttpClient,
    private val articlesDao: ArticlesDao
) : NewsRepository {

    private val tag = "NewsRepository: "
    private val baseUrl = "https://newsdata.io/api/latest"
    private val apiKey = "pub_616841443b05c36ef31ffd5aaf3dde5640763"
    private suspend fun getLocalNews(nextPage: String?): NewsList {
        val localNews = articlesDao.getArticleList()
        println(tag + "getLocalNews " + localNews.size + " nextPage:" + nextPage)

        val newsList = NewsList(
            nextPage = nextPage,
            articles = localNews.map { it.toArticle() }
        )
        return newsList
    }
    private suspend fun getRemoteNews(nextPage: String?): NewsList {
        val newsListDto:NewsListDto = httpClient.get(baseUrl){
            parameter("apiKey",apiKey)
            parameter("q","中文")
            parameter("country","cn")
            parameter("language","zh")
            if (nextPage!= null) parameter("page",nextPage)
        }.body()
        println(tag + "getRemoteNews " + newsListDto.results?.size + " nextPage:" + nextPage)

        return newsListDto.toNewsList()
    }

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