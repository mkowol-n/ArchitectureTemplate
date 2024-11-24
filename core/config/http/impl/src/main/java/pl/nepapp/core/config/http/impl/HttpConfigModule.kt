package pl.nepapp.core.config.http.impl

import okhttp3.OkHttpClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import pl.nepapp.core.settings.BuildConfigProvider
import pl.nepapp.data.authorization.remote.AuthorizationService
import java.util.concurrent.TimeUnit

@Module
@ComponentScan("pl.nepapp.core.config.http.impl")
class HttpConfigModule {

    @Single
    fun provideOkHttp(
        requestInterceptor: RequestInterceptor,
        authenticator: TokenAuthenticator,
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(requestInterceptor)
            authenticator(authenticator)
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
        }.build()
    }

    @Single
    fun provideAuthorizationService(
        builder: RetrofitBuilder,
        buildConfigProvider: BuildConfigProvider
    ): AuthorizationService {
        return builder.build(buildConfigProvider.baseUrl + "someendpoint/").create(AuthorizationService::class.java)
    }
}