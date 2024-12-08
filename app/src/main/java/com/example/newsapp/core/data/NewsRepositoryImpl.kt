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
import io.ktor.utils.io.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
        return flow{
            val remoteNewsList = try {
                getRemoteNews(null)
            }catch (e:Exception){
                e.printStackTrace()
                if (e is CancellationException) throw e
                println(tag + "getNews remote exception:" + e.message)
                null
            }

            remoteNewsList?.let {
                articlesDao.clearDatabase()
                articlesDao.upsertArticleList(remoteNewsList.articles.map { it.toArticleEntity() })
                emit(NewsResult.Success(getLocalNews(remoteNewsList.nextPage)))
                return@flow
            }

            val localNewsList = getLocalNews(null)
            if (localNewsList.articles.isNotEmpty()){
                emit(NewsResult.Success(localNewsList))
                return@flow
            }

            emit(NewsResult.Error("没有数据！"))
        }
    }


    override suspend fun paginate(nextPage: String?): Flow<NewsResult<NewsList>> {
        return flow{
            val remoteNewsList = try {
                getRemoteNews(nextPage)
            }catch (e:Exception){
                e.printStackTrace()
                if (e is CancellationException) throw e
                println(tag + "paginate remote exception:" + e.message)
                null
            }

            remoteNewsList?.let {
                articlesDao.upsertArticleList(remoteNewsList.articles.map { it.toArticleEntity() })
                // 不会像 getNews() 那样从数据库获取它们
                // 因为我们还会获取分页前已经拥有的旧项目
                emit(NewsResult.Success(remoteNewsList))
                return@flow
            }

        }
    }

    override suspend fun getArticle(articleId: String): Flow<NewsResult<Article>> {
        TODO("Not yet implemented")
    }
}