package pl.nepapp.navigation.graphs.maingraph

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import pl.nepapp.features.account.AccountDirection
import pl.nepapp.features.account.AccountScreenRegistry
import pl.nepapp.navigation.graphs.base.BaseNavHost
import pl.nepapp.navigation.graphs.base.registerWithSlideAnimation

@Composable
fun AccountGraph(
    accountScreenRegistry: AccountScreenRegistry = koinInject(),
) {
    BaseNavHost(
        startDestination = AccountDirection
    ) {
        accountScreenRegistry.registerWithSlideAnimation(navGraphBuilder = this@BaseNavHost)
    }
}