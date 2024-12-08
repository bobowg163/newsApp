package com.example.newsapp.news.prensentation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R
import com.example.newsapp.core.prensentation.ui.theme.NewsAppTheme
import org.koin.androidx.compose.koinViewModel

/**
 * @项目 NewsApp
 * ＠包 com.example.newsapp.news.prensentation
 * @作者 bobo
 * @日期及日间 2024/12/8 21:25
 **/

@Composable
fun NewsScreenCore(
    viewModel: NewsViewModel = koinViewModel(),
    onArticleClick: (String) -> Unit
) {
    NewsScreen(
        state = viewModel.state,
        onAction = viewModel::onAction,
        onArticleClick = onArticleClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NewsScreen(
    state: NewsState,
    onAction: (NewsAction) -> Unit,
    onArticleClick: (String) -> Unit
) {
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(
                        text = stringResource(R.string.news),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                },
                windowInsets = WindowInsets(top = 20.dp, bottom = 8.dp)
            )
        }
    ) { innerPadding ->

    }
}

@Preview
@Composable
private fun NewsScreenCorePreview() {
    NewsAppTheme {
        NewsScreen(
            state = NewsState(),
            onAction = {},
            onArticleClick = {}
        )
    }
}