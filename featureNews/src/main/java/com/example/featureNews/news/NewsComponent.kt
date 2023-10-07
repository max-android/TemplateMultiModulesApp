package com.example.featureNews.news

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.EmptyListUi
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.NewsModel

@Composable
fun NewsComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<NewsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ObserveState(state)
}

@Composable
fun ObserveState(state: BaseViewModel.BaseViewState?) {
    state?.let { newsState ->
        when (newsState) {
            is NewsSuccess -> {
                ShowNewsUi(newsState.news)
            }

            is NewsError -> {
                LoadError(newsState.exception)
            }

            is NewsLoading -> {
                DetailShimmerComponent()
            }

            else -> {
            }
        }
    }
}

@Composable
private fun ShowNewsUi(news: List<NewsModel>) {
    if (news.isEmpty()) {
        EmptyListUi()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(news) { _, item ->
                ShowNewsItem(item)
            }
        }
    }
}

@Composable
private fun ShowNewsItem(model: NewsModel) {

}