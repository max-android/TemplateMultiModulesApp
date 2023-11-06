package com.example.featureOpen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.MAX_PRODUCTS_LOAD_COUNT
import com.example.coreUi.SecondaryVariant
import com.example.coreUi.workComponents.ListShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.openCollective.MemberModel

@Composable
fun OpenComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel: OpenViewModel = hiltViewModel<OpenViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lazyColumnListState = rememberLazyListState()
    val shouldStartPaginate = remember {
        derivedStateOf {
            lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1
            lazyColumnListState.layoutInfo.totalItemsCount
//            Log.i("--PAGIN", "----------------isLoading: " + viewModel.isLoading)
//            Log.i("--PAGIN", "----------------lastPage: " + viewModel.lastPage)
//            Log.i(
//                "--PAGIN",
//                "--------visibleItemsInfo: " + lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
//            )
//            Log.i(
//                "--PAGIN",
//                "---------totalItemsCount: " + lazyColumnListState.layoutInfo.totalItemsCount
//            )
            !viewModel.lastPage &&
                    !viewModel.isLoading &&
                    (lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                        ?: -1) >= (lazyColumnListState.layoutInfo.totalItemsCount - MAX_PRODUCTS_LOAD_COUNT)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value) {
            viewModel.obtainEvent(AddOpenList)
        }
    }
    ObserveState(state, lazyColumnListState, viewModel)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    lazyColumnListState: LazyListState,
    viewModel: OpenViewModel,
) {
    state?.let { membersState ->
        when (membersState) {
            is OpenListSuccess -> {
                OpenListUi(membersState, lazyColumnListState, viewModel)
            }

            is OpenListLoading -> {
                ListShimmerComponent()
            }

            is OpenListError -> {
                LoadError(membersState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun OpenListUi(
    listSuccess: OpenListSuccess,
    lazyColumnListState: LazyListState,
    viewModel: OpenViewModel
) {
    LazyColumn(modifier = Modifier.fillMaxSize(), state = lazyColumnListState) {
        itemsIndexed(listSuccess.members, key = { _, item -> item.memberId }) { _, item ->
            OpenItem(item)
        }
        item(
            key = viewModel.isLoading,
        ) {
            Column(
                modifier = Modifier
                    .fillParentMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Refresh Loading"
                )
                CircularProgressIndicator(color = Color.Blue)
            }
        }
    }
}

@Composable
private fun OpenItem(member: MemberModel) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .wrapContentHeight()
            .background(Color.White)
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
    ) {
        AsyncImage(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            model = member.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                text = member.name,
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp),
                text = member.description,
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
        }
    }
}