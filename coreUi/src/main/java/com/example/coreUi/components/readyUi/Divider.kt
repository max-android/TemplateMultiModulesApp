package com.example.coreUi.components.readyUi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = DividerDefaults.color
) {
    androidx.compose.material3.HorizontalDivider(
        modifier = modifier
            .fillMaxWidth(),
        color = color,
        thickness = DividerDefaults.Thickness
    )
}

@Preview
@Composable
fun SamplesDividerPreview() {
    HorizontalDivider(color = Color.Red)
}