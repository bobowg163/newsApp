package com.example.newsapp.core.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data.local
 * @作者 bobo
 * @日期及日间 2024/12/8 16:33
 **/

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM articleentity")
    suspend fun getArticleList():List<ArticleEntity>

    @Upsert
    suspend fun upsertArticleList(articleList: List<ArticleEntity>)

    @Query("SELECT * FROM articleentity WHERE articleId = :articleId")
    suspend fun getArticle(articleId: String): ArticleEntity?

    @Query("DELETE FROM articleentity")
    suspend fun clearDatabase()
}