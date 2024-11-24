package pl.nepapp.features.login.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import pl.nepapp.core.navigation.LocalNavigator
import pl.nepapp.coreui.NepAppScaffold
import pl.nepapp.coreui.buttons.NepAppPrimaryButton
import pl.nepapp.coreui.extensions.currentOrThrow
import pl.nepapp.coreui.inputField.NepAppInputField
import pl.nepapp.coreui.statemanagement.OverlayAsyncHandler
import pl.nepapp.features.dashboard.DashboardDirection


@Composable
fun LoginScreen(viewModel: LoginViewModel = koinViewModel()) {
    val navigator = LocalNavigator.currentOrThrow
    val state by viewModel.collectAsState()
    val focusManager = LocalFocusManager.current

    viewModel.collectSideEffect {
        when(it) {
            LoginViewModel.LoginSideEffect.NavigateToDashboard -> {
                navigator.replaceAll(DashboardDirection)
            }
        }
    }

    NepAppScaffold {
        OverlayAsyncHandler(state = state.loginRequest) {
            Column {
                Spacer(modifier = Modifier.height(40.dp))
                NepAppInputField(
                    label = "Login",
                    inputFieldState = state.loginInputField,
                    onChange = viewModel::onLoginChange,
                )
                Spacer(modifier = Modifier.height(24.dp))
                NepAppInputField(
                    label = "Password",
                    inputFieldState = state.passwordInputField,
                    onChange = viewModel::onPasswordChange,
                )
                Spacer(modifier = Modifier.height(36.dp))
                NepAppPrimaryButton(
                    title = "Login",
                    onClick = {
                        focusManager.clearFocus()
                        viewModel.login()
                    },
                    enabled = state.isButtonEnabled
                )
            }
        }
    }
}