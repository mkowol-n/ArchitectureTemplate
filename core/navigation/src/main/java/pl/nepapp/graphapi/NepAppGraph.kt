package pl.nepapp.navigation

import androidx.compose.runtime.Composable

interface NepAppGraph {
    @Composable
    fun Route()

    @Composable
    fun TodoRoute()

    @Composable
    fun AccountRoute()
}