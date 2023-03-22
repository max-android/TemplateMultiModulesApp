package com.example.coreUi.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetUi() {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetContent = {
            Column() {
                Text("Show Sheet-1")
                Text("Show Sheet-2")
                Text("Show Sheet-3")
                Text("Show Sheet-4")
                Text("Show Sheet-5")
            }
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.Blue
    ) {
        Button(
            onClick = {
                scope.launch {
                    sheetState.show()
                }
            }) {
            Text("Show Sheet: " + sheetState.progress)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetUi2() {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        sheetPeekHeight = 0.dp,
        sheetBackgroundColor = Color.Blue,
        scaffoldState = scaffoldState,
        sheetContent = {
            Column() {
                Text("Show Sheet-1")
                Text("Show Sheet-2")
                Text("Show Sheet-3")
                Text("Show Sheet-4")
                Text("Show Sheet-5")
            }
        }) {
        Button(
            onClick = {
                scope.launch {
                    if (sheetState.isCollapsed) {
                        sheetState.expand()
                    } else {
                        sheetState.collapse()
                    }
                }
            }) {
            Text("Show Sheet: " + sheetState.progress)
        }
    }
}


@Preview
@Composable
fun BottomSheetPreview() {
    // BottomSheetUi()
    BottomSheetUi2()
}