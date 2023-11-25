package com.hafihaf.radca

sealed class Screen(val route: String) {
    object DruzinovkaScreen : Screen("druz_screen")
}
