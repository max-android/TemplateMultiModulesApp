package com.example.featureProfile.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common.R
import com.example.coreUi.Black
import com.example.coreUi.Purple700

@Composable
fun ProfileHeader() {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.title_profile),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = Purple700
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .size(76.dp, 76.dp)
                .background(
                    color = colorResource(id = R.color.red),
                    shape = androidx.compose.foundation.shape.CircleShape
                )
                .align(Alignment.CenterHorizontally),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.wrapContentSize().align(Alignment.Center),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.title_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            color = Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.phone_sample),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            color = Black
        )
    }
}