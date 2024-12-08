package com.example.newsapp.core.domain

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.core.domain
 * @作者 bobo
 * @日期及日间 2024/12/8 16:15
 **/
sealed class NewsResult<T>(
    val data: T? = null,
    val error: Int?
) {
    class Success<T>(data: T?) : NewsResult<T>(data, null)
    class Error<T>(error: String?) : NewsResult<T>(null, error)
}