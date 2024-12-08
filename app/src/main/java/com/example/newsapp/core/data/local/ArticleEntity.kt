package com.example.newsapp.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data.local
 * @作者 bobo
 * @日期及日间 2024/12/8 16:31
 **/

@Entity
data class ArticleEntity(
    @PrimaryKey(autoGenerate = false)
    val articleId: String,
    val title: String,
    val description: String,
    val content: String,
    val pubDate: String,
    val sourceName: String,
    val imageUrl: String
)
