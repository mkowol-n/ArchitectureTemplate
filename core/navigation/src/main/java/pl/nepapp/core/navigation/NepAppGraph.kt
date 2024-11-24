package pl.nepapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface NepAppGraph {
    @Composable
    fun MainRoute(navHostController: NavHostController)

    @Composable
    fun TodoRoute()

    @Composable
    fun AccountRoute()
}