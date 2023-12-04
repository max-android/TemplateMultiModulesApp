package com.example.coreUi.components.readyUi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    text: String,
    contentColor: Color = MaterialTheme.colorScheme.primary
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
        colors = ButtonDefaults.outlinedButtonColors(contentColor = contentColor)
    )
    {
        Icon(
            modifier = Modifier.size(ButtonDefaults.IconSize),
            imageVector = icon,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = text
        )
    }
}

@Composable
fun TextButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    text: String,
    contentColor: Color = MaterialTheme.colorScheme.primary
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
        colors = ButtonDefaults.textButtonColors(contentColor = contentColor)
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = icon,
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = text
            )
        }

    }
}

@Composable
fun FilledTonalButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    text: String
) {
    FilledTonalButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    )
    {
        Icon(
            modifier = Modifier.size(18.dp),
            imageVector = icon,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = text
        )
    }
}

@Composable
fun FilledButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    text: String
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Icon(
            modifier = Modifier.size(18.dp),
            imageVector = icon,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 6.dp),
            text = text
        )
    }
}

@Composable
fun ConfirmButton(
    text: String = "confirm",
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick, enabled = enabled) {
        Text(text)
    }
}

@Composable
fun DismissButton(text: String = "dismiss", onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(text)
    }
}

@Composable
fun LinkButton(
    modifier: Modifier = Modifier,
    text: String = "text",
    icon: ImageVector = Icons.Outlined.OpenInNew,
    link: String = "text-link"
) {
    val uriHandler = LocalUriHandler.current
    TextButtonWithIcon(
        modifier = modifier,
        onClick = { uriHandler.openUri(link) },
        icon = icon,
        text = text
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun LongTapTextButton(
    onClick: () -> Unit,
    onClickLabel: String = "Label",
    onLongClick: () -> Unit,
    onLongClickLabel: String = "Label",
    modifier: Modifier = Modifier,
    shape: Shape = ButtonDefaults.shape,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ButtonWithIconContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    val contentColor = MaterialTheme.colorScheme.primary
    Row(
        modifier = modifier
            .clip(shape)
            .combinedClickable(
                onClick = onClick,
                onClickLabel = onClickLabel,
                onLongClick = onLongClick,
                onLongClickLabel = onLongClickLabel
            ),
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            ProvideTextStyle(value = MaterialTheme.typography.labelLarge) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth,
                            minHeight = ButtonDefaults.MinHeight
                        )
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }

}

@Preview
@Composable
fun SamplesButtonsPreview() {
    Column {
        OutlinedButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = "Outlined",
            onClick = {}
        )
        TextButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = "TextButton",
            onClick = {}
        )
        FilledTonalButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = "TonalButton",
            onClick = {}
        )
        FilledButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = "FilledButton",
            onClick = {}
        )
        ConfirmButton() {}
        DismissButton() {}
        LinkButton()
        LongTapTextButton(onClick = {}, onLongClick = {}) {}
    }
}