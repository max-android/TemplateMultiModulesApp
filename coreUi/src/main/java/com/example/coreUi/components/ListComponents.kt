package com.example.coreUi.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SampleScrollColumn() {

    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        repeat((0..10).count()) {
            Text(
                text = "Title-2",
                fontSize = 76.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}


@Composable
fun SampleLazyColumn() {
    LazyColumn() {
        items(10) {
            Text(
                text = "Title" + it,
                fontSize = 76.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SampleLazyColumn2() {
    LazyColumn() {
        itemsIndexed(listOf("this", "compose", "str", "value", "end")) { index, string ->
            Text(
                text = "Title" + string + index,
                fontSize = 76.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SampleLazyVerticalGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        //columns = GridCells.Adaptive(100.dp),

        content = {
            items(100) {
                androidx.compose.material3.Text(text = "TEXT compose")
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SampleLazyStaggerGrid() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(5),
        //columns = GridCells.Adaptive(100.dp),
        modifier = Modifier.fillMaxSize(),
        //contentPadding = PaddingValues(36.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(100) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(16.dp))
                        //.padding(36.dp)
                        .background(Color.Blue)
                )
            }
        }
    )
}

@Composable
fun CheckedList() {

    val coll = (0..20).map {
        MyItem(
            title = "Item + $it",
            isSelected = false
        )
    }

    var items = remember {
        mutableStateOf(coll)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items.value.size) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        items.value = items.value.mapIndexed { index, myItem ->
                            if (index == it) {
                                myItem.copy(isSelected = !myItem.isSelected)
                            } else  {
                                myItem
                            }
                        }
                    }
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                  Text(text = items.value[it].title)
                if (items.value[it].isSelected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "",
                        tint = Color.Green,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

data class MyItem(
    val title: String,
    val isSelected: Boolean
)

@Preview
@Composable
fun ListComponentsPreview() {
    //SampleScrollColumn()
    //SampleLazyColumn2()
    //SampleLazyVerticalGrid()
    //SampleLazyStaggerGrid()
    CheckedList()
}