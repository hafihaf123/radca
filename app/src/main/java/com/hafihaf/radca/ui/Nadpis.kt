package com.hafihaf.radca.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hafihaf.radca.ui.theme.RadcaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Nadpis(
    modifier: Modifier,
    title: String,
    onClick: () -> Unit
) {
    TopAppBar(
        title = { Text(
            title,
            fontSize = 30.sp
        ) },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp),
                icon = Icons.Default.Menu,
                contentDescription = "menu_button",
                onClick = onClick,
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            )
        }/*,
        actions = {
            IconButton(modifier = , icon = , contentDescription = )
        }*/
    )
}

@Preview(showBackground = true)
@Composable
fun NadpisPreview() {
    RadcaTheme {
        Nadpis(
            title = "Hello World!",
//            textSize = 25,
            modifier = Modifier
                /*.padding(16.dp)*/,
            onClick = {}
        )
    }
}