package com.hafihaf.radca.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hafihaf.radca.util.Routes
import com.hafihaf.radca.util.UiEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material3.DismissibleDrawerSheet as DismissibleDrawerSheet1

@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    onNavigate: (UiEvent.Navigate) -> Unit,
    screenRoute: String,
    content: @Composable () -> Unit
) {
    val items = listOf(
        Icons.Default.Create to Routes.DRUZINOVKA,
        Icons.Default.AddCircle to Routes.TODO
    )
    val selectedItem = remember { mutableStateOf(items[0])}
    
    BackHandler(enabled = drawerState.isOpen) {
        scope.launch { 
            drawerState.close()
        }
    }
    
    DismissibleNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DismissibleDrawerSheet1{
                Spacer(Modifier.height(12.dp))
                items.forEach { (icon, route) ->
                    NavigationDrawerItem(
                        icon = { Icon(icon, contentDescription = null) },
                        label = { Text(route) },
                        selected = route == screenRoute,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = icon to route
                            onNavigate(UiEvent.Navigate(route))
                        },
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                }
            }
        },
        content = { content() }
    )
}