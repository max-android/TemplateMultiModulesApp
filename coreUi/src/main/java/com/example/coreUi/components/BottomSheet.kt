package com.example.coreUi.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
        sheetState = sheetState
    ) {
        Button(
            onClick = {
                scope.launch {
                    sheetState.show()
                }
            }) {
            Text("Show Sheet")
        }
    }
}