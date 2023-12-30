package com.arcanium.readbuddy.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    label: (@Composable () -> Unit)? = null,
    placeHolder: (@Composable () -> Unit)? = null,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        focusedBorderColor = MaterialTheme.colorScheme.primary
    ),
    singleLine: Boolean = true
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        colors = colors,
        label = label,
        placeholder = placeHolder,
        singleLine = singleLine
    )
}