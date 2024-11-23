package pl.nepapp.architecturetemplate

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.pl_nepapp_features_login_impl_LoginModule
import pl.nepapp.features.dashboard.impl.dashboardModule

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                pl_nepapp_features_login_impl_LoginModule,
                dashboardModule
            )
        }

    }
}