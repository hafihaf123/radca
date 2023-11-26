package com.hafihaf.radca

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hafihaf.radca.datastore.StoreDruzContent
import com.hafihaf.radca.ui.IconButton
import com.hafihaf.radca.ui.InputBlock
import com.hafihaf.radca.ui.Nadpis
import com.hafihaf.radca.ui.theme.RadcaTheme
import kotlinx.coroutines.launch

@Composable
fun DruzinovkaScreen() {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val datastore = StoreDruzContent(context)
    val savedDruzContent = datastore.getDruzContent.collectAsState(initial = "")

    var druzContent by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(savedDruzContent.value) {
        // Set druzContent to the value from savedDruzContent when the composable is first launched
        druzContent = savedDruzContent.value!!
    }

    Column (
        modifier = Modifier
            .padding(6.dp, 16.dp)
            .fillMaxSize()
    ) {
        Row (
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            IconButton(
                modifier = Modifier.size(50.dp),
                icon = Icons.Filled.Menu,
                contentDescription = stringResource(R.string.side_menu_button)
            )

            Nadpis(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                text = stringResource(R.string.druzinovka),
                textSize = 30
            )

            IconButton(
                modifier = Modifier.size(50.dp),
                icon = Icons.Filled.Settings,
                contentDescription = stringResource(R.string.settings_button)
            )
        }

        Divider(modifier = Modifier.padding(0.dp, 16.dp))

        InputBlock(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            text = druzContent,
            placeholder = "write here",
            onTextChange = {
                druzContent = it
                scope.launch {
                    datastore.saveDruzContent(druzContent)
                }
            }
        )
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            IconButton(
                modifier = Modifier.size(50.dp),
                icon = Icons.Filled.Add,
                contentDescription = "more"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DruzinovkaScreenPreview() {
    RadcaTheme {
        DruzinovkaScreen()
    }
}