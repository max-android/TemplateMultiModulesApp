package com.example.coreUi.components.readyUi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.HighlightOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PasteFromClipBoardButton(onPaste: (String) -> Unit = {}) {
    val clipboardManager = LocalClipboardManager.current
    PasteButton(onClick = {
        clipboardManager.getText()?.let { onPaste(it.toString()) }
    })
}

@Composable
fun PasteButton(onClick: () -> Unit = {}) {
    IconButton(onClick = onClick) {
        Icon(
            Icons.Outlined.ContentPaste,
            "paste"
        )
    }
}

@Composable
fun AddButton(onClick: () -> Unit, enabled: Boolean = true) {
    IconButton(
        onClick = onClick, enabled = enabled
    ) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "add"
        )
    }
}

@Composable
fun ClearButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Outlined.Cancel,
            contentDescription = "clear",
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(modifier = Modifier, onClick = onClick) {
        Icon(
            painter = painterResource(com.example.common.R.drawable.ic_article),
            contentDescription = stringResource(com.example.common.R.string.country),
        )
    }
}

@Preview
@Composable
fun SamplesIconButtonsPreview() {
    Column {
        PasteFromClipBoardButton()
        Spacer(modifier = Modifier.height(24.dp))
        PasteButton()
        Spacer(modifier = Modifier.height(24.dp))
        AddButton({})
        Spacer(modifier = Modifier.height(24.dp))
        ClearButton({})
        Spacer(modifier = Modifier.height(24.dp))
        BackButton({})
    }
}