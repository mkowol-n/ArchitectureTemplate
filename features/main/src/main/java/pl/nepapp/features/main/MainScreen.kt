package pl.nepapp.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.orbitmvi.orbit.compose.collectSideEffect
import pl.nepapp.core.navigation.NepAppGraph
import pl.nepapp.features.login.LoginDirection

@Composable
fun MainScreen() {
    MainContent()
}

@Composable
internal fun MainContent(
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

    nepAppGraph.MainRoute(navController)
}