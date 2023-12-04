package com.example.featureProfile.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.common.R
import com.example.coreUi.Black
import com.example.coreUi.workComponents.Line


@Composable
fun Settings1Item() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(
                color = colorResource(id = R.color.white)
            )
            .fillMaxWidth()
            .wrapContentHeight()

    ) {
        Settings1Element()
        Line()
        Settings1Element()
    }
}

@Composable
fun Settings1Element() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier.size(42.dp).align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.ic_shows),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(color = colorResource(id = R.color.black))
        )
        Column(
            modifier = Modifier
                .weight(1.0f, true)
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp).align(Alignment.CenterVertically),
        ) {
            androidx.compose.material3.Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = stringResource(id = R.string.setting_text),
                style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                color = Black
            )
            androidx.compose.material3.Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(id = R.string.setting_description),
                style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                color = Black
            )
        }
        Image(
            modifier = Modifier.size(24.dp).align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.arrow_forward),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

