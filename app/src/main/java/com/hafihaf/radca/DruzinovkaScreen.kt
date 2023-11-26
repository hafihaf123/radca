package com.hafihaf.radca

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hafihaf.radca.datastore.StoreDruzContent
import com.hafihaf.radca.ui.InputBlock
import com.hafihaf.radca.ui.Nadpis
import com.hafihaf.radca.ui.theme.RadcaTheme
import kotlinx.coroutines.launch

@Composable
fun DruzinovkaScreen(/*navController: NavController*/) {

    val appLaunched by remember { mutableStateOf(true) }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val datastore = StoreDruzContent(context)
    val savedDruzContent = datastore.getDruzContent.collectAsState(initial = "")

    var druzContent by rememberSaveable { mutableStateOf("") }

    if (appLaunched) {
        druzContent = savedDruzContent.value!!
//        appLaunched = false
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column {
            Nadpis(
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.druzinovka)
            )

            InputBlock(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                text = druzContent,
                onTextChange = {
                    druzContent = it
                    scope.launch {
                        datastore.saveDruzContent(druzContent)
                    }
                }
            )
        }
        /* MoreButton */
    }
}

@Preview(showBackground = true)
@Composable
fun DruzinovkaScreenPreview() {
    RadcaTheme {
        DruzinovkaScreen()
    }
}