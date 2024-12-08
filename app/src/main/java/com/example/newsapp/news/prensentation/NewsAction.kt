package com.example.newsapp.news.prensentation

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.news.prensentation
 * @作者 bobo
 * @日期及日间 2024/12/8 20:46
 **/
sealed interface NewsAction {
    data object Paginate:NewsAction
}