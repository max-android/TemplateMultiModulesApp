package com.example.coreUi.components.customCharts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


data class StackedData(
    val inputs: List<Float>,
    val colors: List<androidx.compose.ui.graphics.Color>
)

@Composable
fun stackedBarChartInputs() = (0..5).map {
    val inputs = (0..2).map { (1..100).random().toFloat() }.toPercent()
    StackedData(
        inputs = inputs,
        colors = listOf(
            MaterialTheme.colors.primary,
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.colors.secondary
        )
    )
}

private val defaultMaxHeight = 200.dp

@Composable
internal fun StackedBarChart(
    modifier: Modifier = Modifier,
    values: List<StackedData>,
    maxHeight: Dp = defaultMaxHeight
) {

    val borderColor = MaterialTheme.colors.primary
    val density = LocalDensity.current
    val strokeWidth = with(density) { 2.dp.toPx() }

    Row(
        modifier = modifier.then(
            Modifier
                .fillMaxWidth()
                .height(maxHeight)
                .drawBehind {
                    // draw X-Axis
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidth
                    )
                    // draw Y-Axis
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height),
                        strokeWidth = strokeWidth
                    )
                }
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {

        values.forEach { item ->

            Column(modifier = Modifier.weight(1f)) {

                item.inputs.forEachIndexed { index, input ->

                    val itemHeight = remember(input) { input * maxHeight.value / 100 }

                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .height(itemHeight.dp)
                            .fillMaxWidth()
                            .background(item.colors[index])
                    )
                }
            }
        }

    }

}

@Preview
@Composable
fun StackedBarScreenPreview() {
    StackedBarChart(
        modifier = Modifier.padding(20.dp),
        values = stackedBarChartInputs()
    )
}