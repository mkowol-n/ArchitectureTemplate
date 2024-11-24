package pl.nepapp.features.account.impl

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectSideEffect
import pl.nepapp.core.navigation.LocalNavigator
import pl.nepapp.coreui.NepAppScaffold
import pl.nepapp.coreui.buttons.NepAppPrimaryButton
import pl.nepapp.coreui.extensions.currentOrThrow
import pl.nepapp.features.login.LoginDirection

@Composable
fun AccountScreen(viewModel: AccountViewModel = koinViewModel()) {
    val navigator = LocalNavigator.currentOrThrow

    viewModel.collectSideEffect {
        when(it) {
            AccountViewModel.AccountSideEffect.LogoutUser -> {
                navigator.parent.replaceAll(LoginDirection)
            }
        }
    }

    NepAppScaffold {
        NepAppPrimaryButton(
            title = "Logout",
            onClick = viewModel::logout
        )
    }
}