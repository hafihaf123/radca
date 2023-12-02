package com.hafihaf.radca

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.hafihaf.radca.ui.IconButton
import com.hafihaf.radca.ui.InputBlock
import com.hafihaf.radca.ui.Nadpis
import com.hafihaf.radca.ui.NavigationDrawer
import com.hafihaf.radca.ui.theme.RadcaTheme
import com.hafihaf.radca.util.Routes
import com.hafihaf.radca.util.UiEvent
import kotlinx.coroutines.launch

@Composable
fun DruzinovkaScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val datastore = StoreDruzContent(context)
    val savedDruzContent = datastore.getDruzContent.collectAsState(initial = "")

    var druzContent by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(savedDruzContent.value) {
        // Set druzContent to the value from savedDruzContent when the composable is first launched
        druzContent = savedDruzContent.value!!
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }


    NavigationDrawer(
        drawerState = drawerState,
        scope = scope,
        onNavigate = onNavigate,
        screenRoute = Routes.DRUZINOVKA
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            floatingActionButton = {
                IconButton(
                    modifier = Modifier,
//                    .padding(6.dp)
//                    .size(50.dp),
                    icon = Icons.Filled.Delete,
                    contentDescription = "delete",
                    onClick = { druzContent = "" }
                )
            },
            topBar = {
                Nadpis(
                    modifier = Modifier,
                    title = stringResource(R.string.druzinovka),
                    onClick = { scope.launch { drawerState.open() } }
                )
            }
        ) { innerPadding ->
            InputBlock(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(6.dp, 12.dp)
                    .fillMaxSize(),
                text = druzContent,
                placeholder = "write here",
                onTextChange = {
                    druzContent = it
                    scope.launch {
                        datastore.saveDruzContent(druzContent)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DruzinovkaScreenPreview() {
    RadcaTheme {
        DruzinovkaScreen(
            onNavigate = { }
        )
    }
}