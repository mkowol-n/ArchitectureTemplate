package pl.nepapp.data.authorization.remote.impl

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import pl.nepapp.core.config.http.RetrofitBuilder
import pl.nepapp.core.settings.BuildConfigProvider
import pl.nepapp.data.authorization.remote.AuthorizationService

@Module
@ComponentScan("pl.nepapp.data.authorization.remote.impl")
class DataAuthorizationRemoteModule {

    @Single
    fun provideAuthorizationService(
        builder: RetrofitBuilder,
        buildConfigProvider: BuildConfigProvider
    ): AuthorizationService {
        return builder.build(buildConfigProvider.baseUrl + "someendpoint/").create(
            AuthorizationService::class.java)
    }

}