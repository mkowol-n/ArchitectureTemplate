package pl.nepapp.architecturetemplate

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.pl_nepapp_core_config_http_HttpConfigModule
import org.koin.ksp.generated.pl_nepapp_features_login_impl_LoginModule
import pl.nepapp.core.config.shared.sharedConfigModule
import pl.nepapp.data.authorization.impl.authorizationDataModule
import pl.nepapp.features.dashboard.impl.dashboardModule
import timber.log.Timber

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                pl_nepapp_features_login_impl_LoginModule,
                pl_nepapp_core_config_http_HttpConfigModule,
                dashboardModule,
                authorizationDataModule,
                sharedConfigModule
            )
        }

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}