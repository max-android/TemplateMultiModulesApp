package com.example.coreUi.workComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common.NoInternetException
import com.example.common.R
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

@Composable
fun LoadError(throwable: Throwable) {
    val errorMessage = when (throwable) {
        is UnknownHostException,
        is ConnectException,
        is SocketTimeoutException,
        is NoInternetException
        -> {
            stringResource(id = R.string.not_network)
        }
        else -> {
            throwable.message.orEmpty()
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_error),
            contentDescription = null,
            modifier = Modifier
                .size(125.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Center,
            text = errorMessage,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}