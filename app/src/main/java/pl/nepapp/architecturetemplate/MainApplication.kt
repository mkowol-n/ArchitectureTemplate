package pl.nepapp.architecturetemplate

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import pl.nepapp.features.dashboard.impl.dashboardModule
import pl.nepapp.features.login.impl.loginModule

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                loginModule,
                dashboardModule
            )
        }

    }
}