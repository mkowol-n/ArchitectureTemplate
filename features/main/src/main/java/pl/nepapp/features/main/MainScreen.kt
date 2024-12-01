package pl.nepapp.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.orbitmvi.orbit.compose.collectSideEffect
import pl.nepapp.coreui.theme.NepAppThemeProvider
import pl.nepapp.features.NepAppGraph
import pl.nepapp.features.login.LoginDirection

@Composable
fun MainScreen(initialScreenIsLogin: Boolean) {

    NepAppThemeProvider {
        MainContent(initialScreenIsLogin)
    }
}

@Composable
internal fun MainContent(
    initialScreenIsLogin: Boolean,
    nepAppGraph: NepAppGraph = koinInject(),
    mainViewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberNavController()

    mainViewModel.collectSideEffect {
        when(it) {
            MainViewModel.MainSideEffect.LogoutUser -> {
                navController.navigate(LoginDirection) {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            }
        }
    }

    nepAppGraph.MainRoute(navController, initialScreenIsLogin = initialScreenIsLogin)
}