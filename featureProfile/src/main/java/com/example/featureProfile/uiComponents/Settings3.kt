package com.example.featureProfile.uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common.R
import com.example.coreUi.Black
import com.example.coreUi.workComponents.Line

@Composable
fun Setting3Item() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(
                    color = colorResource(id = R.color.white)
                )
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            val checked = remember { mutableStateOf(true) }
            androidx.compose.material3.Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, true)
                    .align(alignment = Alignment.CenterVertically),
                text = stringResource(id = R.string.setting_description),
                textAlign = TextAlign.Start,
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                color = Black
            )
            Switch(
                modifier = Modifier
                    .wrapContentSize()
                    .align(alignment = Alignment.CenterVertically),
                checked = checked.value,
                onCheckedChange = {
                    checked.value = it
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(
                    color = colorResource(id = R.color.white)
                )
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                val checked = remember { mutableStateOf(true) }
                androidx.compose.material3.Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, true)
                        .align(alignment = Alignment.CenterVertically),
                    text = stringResource(id = R.string.setting_description),
                    textAlign = TextAlign.Start,
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    color = Black
                )
                Checkbox(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(alignment = Alignment.CenterVertically),
                    checked = checked.value,
                    onCheckedChange = {
                        checked.value = it
                    }
                )
            }
            Line()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                val checked = remember { mutableStateOf(true) }
                androidx.compose.material3.Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, true)
                        .align(alignment = Alignment.CenterVertically),
                    text = stringResource(id = R.string.setting_description),
                    textAlign = TextAlign.Start,
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    color = Black
                )
                Checkbox(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(alignment = Alignment.CenterVertically),
                    checked = checked.value,
                    onCheckedChange = {
                        checked.value = it
                    }
                )
            }
        }
    }
}

