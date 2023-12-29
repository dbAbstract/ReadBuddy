package com.arcanium.readbuddy.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable

@Composable
fun AppTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    label: (@Composable () -> Unit)? = null,
    placeHolder: (@Composable () -> Unit)? = null,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        focusedBorderColor = MaterialTheme.colorScheme.primary
    )
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        colors = colors,
        label = label,
        placeholder = placeHolder
    )
}