package com.example.featureProfile.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common.R
import com.example.coreUi.Black

@Composable
fun HistoryList() {
    LazyRow(contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)) {
        val list = 1..20
        itemsIndexed(list.toList()) { _, _ ->
            HistoryItem()
        }
    }
}

@Composable
private fun HistoryItem() {
    Column(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = colorResource(id = R.color.white))
            .wrapContentSize()
            .padding(16.dp)
    ) {
        Image(
            modifier = Modifier
                .size(86.dp, 100.dp)
                .align(alignment = Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_team),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        androidx.compose.material3.Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
            .align(alignment = Alignment.Start)
                     ,
            text = stringResource(id = R.string.setting_description),
           // textAlign = TextAlign.Start,
            style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
            color = Black
        )
    }
}