package com.hafihaf.radca.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hafihaf.radca.ui.theme.RadcaTheme

@Composable
fun Nadpis(
    modifier: Modifier,
    text: String,
    textSize: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = textSize.sp,
            fontWeight = FontWeight.Bold
        )
//        Divider(modifier = Modifier.padding(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun NadpisPreview() {
    RadcaTheme {
        Nadpis(
            text = "Hello World!",
            textSize = 25,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}