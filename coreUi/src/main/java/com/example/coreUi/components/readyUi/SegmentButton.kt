package com.example.coreUi.components.readyUi

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleChoiceSegmentedButtonRowScope.SingleChoiceSegmentedButton(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    position: SegmentedButtonValues = SegmentedButtonValues.END,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    SegmentedButton(
        selected = selected, onClick = onClick,
        enabled = enabled,
        modifier = modifier.height(36.dp),
        colors = SegmentedButtonDefaults.colors(inactiveContainerColor = Color.Transparent),
        shape = when (position) {
            SegmentedButtonValues.END -> EndSegmentedButtonShape
            SegmentedButtonValues.MIDDLE -> RectangleShape
            SegmentedButtonValues.START -> StartSegmentedButtonShape
        },
    ) {
        Text(text = text)
    }
}

private val StartSegmentedButtonShape =
    RoundedCornerShape(topStartPercent = 100, bottomStartPercent = 100)

private val EndSegmentedButtonShape =
    RoundedCornerShape(topEndPercent = 100, bottomEndPercent = 100)

sealed interface SegmentedButtonValues {
    object START : SegmentedButtonValues
    object END : SegmentedButtonValues
    object MIDDLE : SegmentedButtonValues
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SamplesSegmentPreview() {
    SingleChoiceSegmentedButtonRow(modifier = Modifier.padding(56.dp)) {
        this.SingleChoiceSegmentedButton(text = "пример", selected = true) {

        }
    }
}