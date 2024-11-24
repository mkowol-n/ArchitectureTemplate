package pl.nepapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface NepAppGraph {
    @Composable
    fun MainRoute(navHostController: NavHostController, initialScreenIsLogin: Boolean)

    @Composable
    fun TodoRoute()

    @Composable
    fun AccountRoute()
}