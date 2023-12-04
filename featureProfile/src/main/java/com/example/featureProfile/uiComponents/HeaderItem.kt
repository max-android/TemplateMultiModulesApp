package com.example.featureProfile.uiComponents

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.coreUi.Black

@Composable
fun HeaderItem(@StringRes titleId: Int) {
    Text(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 16.dp),
        text = stringResource(id = titleId),
        style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
        color = Black
    )
}

