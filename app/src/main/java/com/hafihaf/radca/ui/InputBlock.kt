package com.hafihaf.radca.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hafihaf.radca.ui.theme.RadcaTheme

@Composable
fun InputBlock(
    modifier: Modifier,
    text: String,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onTextChange(it) },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun InputBlockPreview() {
    RadcaTheme {
        InputBlock(
            text = "Hello World!\nashdvsufsu\naojhdbduoa\n\ndge",
            onTextChange = {},
            modifier = Modifier
                .padding(16.dp)
        )
    }
}