package com.hafihaf.radca.util

import androidx.compose.material3.SnackbarDuration

sealed class UiEvent {
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class ShowSnackbar(
        val message: String,
        val action: String? = null,
        val withDismissAction: Boolean? = true,
        val duration: SnackbarDuration? = SnackbarDuration.Short
    ): UiEvent()
}
