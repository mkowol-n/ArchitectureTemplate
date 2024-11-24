package pl.nepapp.architecturetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.koin.android.ext.android.inject
import org.koin.compose.KoinContext
import pl.nepapp.features.main.MainScreen

class MainActivity : ComponentActivity() {

    private val mainActivityViewModel by inject<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition {
            mainActivityViewModel.isFirstScreenLogin.value == null
        }
        super.onCreate(savedInstanceState)
        setContent {
            KoinContext {
                val state by mainActivityViewModel.isFirstScreenLogin.collectAsState()
                state?.let {
                    MainScreen(it)
                }
            }
        }
    }
}