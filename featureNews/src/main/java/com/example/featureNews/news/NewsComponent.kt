package com.example.featureNews.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.coreUi.Purple700
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
private fun ShowNewsItem(item: NewsModel) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        AsyncImage(
            model = item.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.title,
            style = MaterialTheme.typography.headlineMedium,
            color = Purple700
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(id = com.example.common.R.string.article_author_news),
                style = MaterialTheme.typography.headlineMedium,
                color = Purple700
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = item.author,
                style = MaterialTheme.typography.headlineMedium,
                color = Purple700,
                textDecoration = TextDecoration.Underline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(id = com.example.common.R.string.date),
                style = MaterialTheme.typography.headlineMedium,
                color = Purple700
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = item.date,
                style = MaterialTheme.typography.headlineMedium,
                color = Purple700,
                textDecoration = TextDecoration.Underline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(id = com.example.common.R.string.article_read_more_news),
                style = MaterialTheme.typography.headlineMedium,
                color = Purple700
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = item.readMoreUrl,
                style = MaterialTheme.typography.headlineMedium,
                color = Purple700,
                textDecoration = TextDecoration.Underline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            modifier = Modifier.padding(16.dp),
            text = item.content,
            style = MaterialTheme.typography.bodySmall,
            color = Purple700
        )
    }
}

@Preview
@Composable
fun BackgroundPreview() {
    val list = listOf(
        NewsModel(
            "0",
            "Title news",
            "Author news Author news Author news Author news",
            "12.05.2000",
            "https://static.tvmaze.com/uploads/images/medium_portrait/0/1752.jpg",
            "https://static.tvmaze.com/uploads/images/medium_portrait/0/1752.jpg",
            "Медь требуется организму для преобразования железа в форму, используемую гемоглобином, и является важным компонентом многих необходимых ферментов, включая супероксиддисмутазу, главный клеточный антиоксидант. Она также необходима для здоровой работы иммунной системы и синтеза определенных белков. Людям, которые ежедневно потребляют более 50 мг цинка и/или много фруктозы, рекомендуется дополнить свой рацион 2 мг меди несколько раз в неделю."
        )
    )

    ShowNewsUi(list)

}