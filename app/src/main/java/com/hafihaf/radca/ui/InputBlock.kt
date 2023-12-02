package com.hafihaf.radca.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hafihaf.radca.ui.theme.RadcaTheme

@Composable
fun InputBlock(
    modifier: Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onTextChange(it) },
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        placeholder = { Text(text = placeholder, fontStyle = FontStyle.Italic) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            focusedBorderColor = MaterialTheme.colorScheme.background,
            unfocusedBorderColor = MaterialTheme.colorScheme.background,
            disabledBorderColor = MaterialTheme.colorScheme.background,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun InputBlockPreview() {
    RadcaTheme {
        InputBlock(
            text = "Hello World!\nashdvsufsu\naojhdbduoa\n\ndge",
            onTextChange = {},
            placeholder = "write here",
            modifier = Modifier
                .padding(16.dp)
        )
    }
}