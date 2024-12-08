package com.example.newsapp.core.prensentation

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.prensentation
 * @作者 bobo
 * @日期及日间 2024/12/8 21:16
 **/
sealed interface Screen {
    @kotlinx.serialization.Serializable
    data object News : Screen

    @kotlinx.serialization.Serializable
    data class Article(val articleId: String) : Screen
}