package pl.nepapp.architecturetemplate

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.pl_nepapp_architecturetemplate_AppModule
import org.koin.ksp.generated.pl_nepapp_core_common_impl_CommonModule
import org.koin.ksp.generated.pl_nepapp_core_config_database_DatabaseModule
import org.koin.ksp.generated.pl_nepapp_core_config_http_impl_HttpConfigModule
import org.koin.ksp.generated.pl_nepapp_core_navigation_impl_NavigationModule
import org.koin.ksp.generated.pl_nepapp_core_settings_localimpl_LocalSettingsModule
import org.koin.ksp.generated.pl_nepapp_features_account_impl_AccountModule
import org.koin.ksp.generated.pl_nepapp_features_dashboard_impl_DashboardModule
import org.koin.ksp.generated.pl_nepapp_features_login_impl_LoginModule
import org.koin.ksp.generated.pl_nepapp_features_main_MainModule
import org.koin.ksp.generated.pl_nepapp_features_tododetails_impl_TodoListModule
import org.koin.ksp.generated.pl_nepapp_features_todolist_impl_TodoListModule
import org.koin.ksp.generated.pl_nepapp_usecases_emailvalidator_impl_EmailValidatorModule
import pl.nepapp.core.config.shared.sharedConfigModule
import pl.nepapp.data.authorization.impl.authorizationDataModule
import pl.nepapp.data.todo.impl.todoDataModule
import pl.nepapp.usecases.combined.impl.combinedUseCaseModule
import timber.log.Timber

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                pl_nepapp_features_login_impl_LoginModule,
                pl_nepapp_core_config_http_impl_HttpConfigModule,
                authorizationDataModule,
                todoDataModule,
                sharedConfigModule,
                pl_nepapp_features_account_impl_AccountModule,
                pl_nepapp_features_tododetails_impl_TodoListModule,
                pl_nepapp_features_todolist_impl_TodoListModule,
                pl_nepapp_features_dashboard_impl_DashboardModule,
                pl_nepapp_core_navigation_impl_NavigationModule,
                pl_nepapp_core_settings_localimpl_LocalSettingsModule,
                pl_nepapp_core_common_impl_CommonModule,
                pl_nepapp_architecturetemplate_AppModule,
                pl_nepapp_core_config_database_DatabaseModule,
                pl_nepapp_features_main_MainModule,
                combinedUseCaseModule,
                pl_nepapp_usecases_emailvalidator_impl_EmailValidatorModule,
            )
        }

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}