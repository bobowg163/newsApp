package com.example.newsapp.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.data.local
 * @作者 bobo
 * @日期及日间 2024/12/8 16:37
 **/

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class ArticleDatabase:RoomDatabase(){
    abstract val dao:ArticlesDao
}
