package com.example.newsapp.article.di


import com.example.newsapp.article.prensentation.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.article.di
 * @作者 bobo
 * @日期及日间 2024/12/10 19:17
 **/

val articleModule = module {
    viewModel { ArticleViewModel(get()) }
}