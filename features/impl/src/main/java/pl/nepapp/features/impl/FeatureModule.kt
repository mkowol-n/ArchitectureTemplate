package pl.nepapp.features.impl

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ksp.generated.pl_nepapp_features_account_impl_AccountModule
import org.koin.ksp.generated.pl_nepapp_features_dashboard_impl_DashboardModule
import org.koin.ksp.generated.pl_nepapp_features_login_impl_LoginModule
import org.koin.ksp.generated.pl_nepapp_features_tododetails_impl_TodoListModule
import org.koin.ksp.generated.pl_nepapp_features_todolist_impl_TodoListModule
import pl.nepapp.features.NepAppGraph

val featureModule = module{
    singleOf<NepAppGraph>(::NepAppGraphImpl)
    includes(
        pl_nepapp_features_login_impl_LoginModule,
        pl_nepapp_features_account_impl_AccountModule,
        pl_nepapp_features_tododetails_impl_TodoListModule,
        pl_nepapp_features_todolist_impl_TodoListModule,
        pl_nepapp_features_dashboard_impl_DashboardModule,
    )
}