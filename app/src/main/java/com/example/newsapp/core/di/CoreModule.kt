package com.example.newsapp.core.di

import androidx.room.Room
import com.example.newsapp.core.data.local.ArticleDatabase
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.di
 * @作者 bobo
 * @日期及日间 2024/12/8 16:39
 **/

val coreModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            ArticleDatabase::class.java,
            "article.db"
        )
            .build()
    }

    single { get<ArticleDatabase>().dao }

    single {
        HttpClient(CIO) {
            expectSuccess = true
            engine {
                endpoint {
                    keepAliveTime = 5000
                    connectTimeout = 5000
                    connectAttempts = 3
                }
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }

            install(Logging){
                logger = object : Logger{
                    override fun log(message: String) {
                        println(message)
                    }

                }
                level = LogLevel.ALL
            }
        }
    }
}