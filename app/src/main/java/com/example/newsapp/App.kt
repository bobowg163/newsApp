package com.example.newsapp

import android.app.Application
import com.example.newsapp.article.di.articleModule
import com.example.newsapp.core.di.coreModule
import com.example.newsapp.news.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp
 * @作者 bobo
 * @日期及日间 2024/12/8 17:32
 **/
class App:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(
                coreModule,
                newsModule,
                articleModule
            )
        }
    }
}