package pl.nepapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface NepAppGraph {
    @Composable
    fun Route()

    @Composable
    fun TodoRoute()

    @Composable
    fun AccountRoute()
}