package com.example.coreUi.components.readyUi

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonChip(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    iconDescription: String? = null,
    onClick: () -> Unit,
) {
    ElevatedAssistChip(
        modifier = modifier.padding(horizontal = 4.dp),
        onClick = onClick,
        label = { Text(label) },
        colors = AssistChipDefaults.elevatedAssistChipColors(leadingIconContentColor = iconColor),
        enabled = enabled,
        leadingIcon = {
            if (icon != null) Icon(
                imageVector = icon,
                contentDescription = iconDescription,
                modifier = Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlatButtonChip(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    label: String,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    labelColor: Color = MaterialTheme.colorScheme.onSurface,
    onClick: () -> Unit
) {
    AssistChip(
        modifier = modifier.padding(horizontal = 4.dp),
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            labelColor = labelColor,
            leadingIconContentColor = iconColor
        ),
        border = null,
        onClick = onClick,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null, Modifier.size(AssistChipDefaults.IconSize)
            )
        },
        label = { Text(text = label) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedButtonChip(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    AssistChip(modifier = modifier, onClick = onClick, leadingIcon = {
        Icon(
            imageVector = icon,
            contentDescription = null, Modifier.size(AssistChipDefaults.IconSize)
        )
    }, label = { Text(text = label) })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleChoiceChip(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit,
    label: String,
    leadingIcon: ImageVector = Icons.Outlined.Check
) {
    FilterChip(
        modifier = modifier.padding(horizontal = 4.dp),
        selected = selected,
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.large,
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Row {
                AnimatedVisibility(visible = selected) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            }
        },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoFilterChip(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit,
    label: String, leadingIcon: ImageVector? = null
) {
    FilterChip(
        modifier = modifier.padding(horizontal = 4.dp),
        selected = selected, enabled = enabled,
        onClick = onClick,
        label = {
            Text(text = label)
        },
        leadingIcon = { leadingIcon?.let { Icon(imageVector = it, contentDescription = null) } }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShortcutChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null,
    onRemove: (() -> Unit)? = null,
) {
    AssistChip(
        modifier = modifier.padding(horizontal = 4.dp),
        onClick = { onClick?.invoke() },
        label = { Text(text = text, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        trailingIcon = {
            onRemove?.let {
                IconButton(
                    onClick = onRemove,
                    modifier = Modifier.size(InputChipDefaults.IconSize)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = stringResource(id = com.example.common.R.string.remove),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(InputChipDefaults.IconSize)
                    )
                }
            }
        })
}

@Preview
@Composable
fun SamplesChipsPreview() {
    Column {
        ButtonChip(
            label = "Base",
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article)
        ) {}
        FlatButtonChip(
            label = "FlatButton",
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article)
        ) {

        }
        OutlinedButtonChip(
            label = "Outlined",
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article)
        ) {

        }
        SingleChoiceChip(
            selected = true,
            label = "SingleChoice",
            onClick = {}
        )
        VideoFilterChip(
            selected = true,
            label = "VideoFilter",
            onClick = {}
        )
        ShortcutChip(text = "Shortcut")
    }
}