package com.example.featureProfile.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.common.R
import com.example.coreUi.Black
import com.example.coreUi.components.readyUi.FilledButtonWithIcon

@Composable
fun Settings2Item() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1.0f, true)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(
                        color = colorResource(id = R.color.white)
                    )
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp)
            ) {
                Row(modifier = Modifier.wrapContentSize()) {
                    androidx.compose.material3.Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(alignment = Alignment.CenterVertically),
                        text = stringResource(id = R.string.setting_text),
                        style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                        color = Black
                    )
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.arrow_forward),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                androidx.compose.material3.Text(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = stringResource(id = R.string.setting_description),
                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                    color = Black
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1.0f, true)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(
                        color = colorResource(id = R.color.white)
                    )
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp)
            ) {
                Row(modifier = Modifier.wrapContentSize()) {
                    androidx.compose.material3.Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(alignment = Alignment.CenterVertically),
                        text = stringResource(id = R.string.setting_text),
                        style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                        color = Black
                    )
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.arrow_forward),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                androidx.compose.material3.Text(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = stringResource(id = R.string.setting_description),
                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                    color = Black
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        FilledButtonWithIcon(
            icon = ImageVector.vectorResource(id = R.drawable.ic_article),
            text = stringResource(id = R.string.setting_text),
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}