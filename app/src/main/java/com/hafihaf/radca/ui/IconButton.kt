package com.hafihaf.radca.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.hafihaf.radca.ui.theme.RadcaTheme

@Composable
fun IconButton(
    modifier: Modifier,
    icon: ImageVector,
    contentDescription: String
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = { /*TODO*/ }
    ) {
        Icon(icon, contentDescription)
    }
}

@Preview(showBackground = true)
@Composable
fun IconButtonPreview() {
    RadcaTheme {
        IconButton(
            modifier = Modifier,
            icon = Icons.Filled.Add,
            contentDescription = ""
        )
    }
}