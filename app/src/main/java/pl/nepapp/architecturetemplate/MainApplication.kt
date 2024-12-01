package pl.nepapp.architecturetemplate

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.pl_nepapp_architecturetemplate_AppModule
import org.koin.ksp.generated.pl_nepapp_core_common_impl_CommonModule
import org.koin.ksp.generated.pl_nepapp_core_config_http_impl_HttpConfigModule
import org.koin.ksp.generated.pl_nepapp_core_navigation_impl_NavigationModule
import org.koin.ksp.generated.pl_nepapp_core_settings_localimpl_LocalSettingsModule
import org.koin.ksp.generated.pl_nepapp_core_thirdparty_SharedConfigModule
import org.koin.ksp.generated.pl_nepapp_data_authorization_remote_impl_DataAuthorizationRemoteModule
import org.koin.ksp.generated.pl_nepapp_data_todo_local_impl_TodoDatabaseModule
import org.koin.ksp.generated.pl_nepapp_features_main_MainModule
import org.koin.ksp.generated.pl_nepapp_usecases_emailvalidator_impl_EmailValidatorModule
import pl.nepapp.data.authorization.impl.authorizationDataModule
import pl.nepapp.data.todo.impl.todoDataModule
import pl.nepapp.features.impl.featureModule
import pl.nepapp.usecases.combined.impl.combinedUseCaseModule
import timber.log.Timber

open class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        setupDevTools()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                authorizationDataModule,
                todoDataModule,
                pl_nepapp_core_navigation_impl_NavigationModule,
                pl_nepapp_core_settings_localimpl_LocalSettingsModule,
                pl_nepapp_core_common_impl_CommonModule,
                pl_nepapp_architecturetemplate_AppModule,
                combinedUseCaseModule,
                pl_nepapp_usecases_emailvalidator_impl_EmailValidatorModule,
                featureModule,
                pl_nepapp_features_main_MainModule,
                pl_nepapp_core_config_http_impl_HttpConfigModule,
                pl_nepapp_data_authorization_remote_impl_DataAuthorizationRemoteModule,
                pl_nepapp_data_todo_local_impl_TodoDatabaseModule,
                pl_nepapp_core_thirdparty_SharedConfigModule
            )
        }

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    protected open fun setupDevTools() {
        // nothing here, only for override
    }

}