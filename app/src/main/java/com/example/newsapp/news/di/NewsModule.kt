package com.example.newsapp.news.di

import com.example.newsapp.news.prensentation.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.news.di
 * @作者 bobo
 * @日期及日间 2024/12/8 22:34
 **/

val newsModule = module {
    viewModel { NewsViewModel(get()) }
}