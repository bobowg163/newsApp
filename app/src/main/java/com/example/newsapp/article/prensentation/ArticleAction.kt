package com.example.newsapp.article.prensentation

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.article.prensentation
 * @作者 bobo
 * @日期及日间 2024/12/9 21:46
 **/
sealed interface ArticleAction {
    data class LoadArticle(val articleId: String) : ArticleAction
}