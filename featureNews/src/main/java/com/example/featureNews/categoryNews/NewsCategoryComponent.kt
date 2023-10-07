package com.example.featureNews.categoryNews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.EmptyListUi
import com.example.navigation.KEY_CATEGORY_ID
import com.example.navigation.KEY_SHOWS_ID
import com.example.navigation.Screen
import com.example.navigation.navigateSafe
import com.example.navigation.navigateWithBundleSafe

@Composable
fun NewsCategoryComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<NewsCategoryViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickCategoryItem = { category -> viewModel.obtainEvent(ShowNewsEvent(category)) }
    )
    ObserveSideEffect(sideEffect, navController)
}

@Composable
fun ObserveState(state: BaseViewModel.BaseViewState?, onClickCategoryItem: (String) -> Unit) {
    state?.let { newsCategoryState ->
        when (newsCategoryState) {
            is NewsCategorySuccess -> {
                ShowsNewsCategoryUi(newsCategoryState.categories, onClickCategoryItem)
            }

            is NewsCategoryLoading -> {
                DetailShimmerComponent()
            }

            else -> {
            }
        }
    }
}

@Composable
fun ShowsNewsCategoryUi(categories: List<String>, onClickCategoryItem: (String) -> Unit) {
    if (categories.isEmpty()) {
        EmptyListUi()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(categories) { _, item ->
                NewsCategoryItem(item, onClickCategoryItem)
            }
        }
    }
}

@Composable
private fun NewsCategoryItem(category: String, onClickCategoryItem: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
            .background(Color.White)
            .clickable { onClickCategoryItem.invoke(category) }
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 24.dp),
            text = category,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { newsCategorySideEffect ->
        when (newsCategorySideEffect) {
            is NewsCategoryEffect -> {
                navController.navigateWithBundleSafe(
                    Screen.NewsScreen.route,
                    bundleOf(KEY_CATEGORY_ID to newsCategorySideEffect.category)
                )
            }

            else -> {}
        }
    }
}