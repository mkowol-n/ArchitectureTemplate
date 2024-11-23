package pl.nepapp.core.config.http

import okhttp3.OkHttpClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import pl.nepapp.data.authorization.remote.AuthorizationService
import java.util.concurrent.TimeUnit

@Module
@ComponentScan("pl.nepapp.core.config.http")
class HttpConfigModule {

    @Single
    fun provideOkHttp(
        requestInterceptor: RequestInterceptor,
        errorMapperInterceptor: ErrorMapperInterceptor,
        authenticator: TokenAuthenticator,
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(requestInterceptor)
            addInterceptor(errorMapperInterceptor)
            authenticator(authenticator)
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
        }.build()
    }

    @Single
    fun provideAuthorizationService(builder: RetrofitBuilder): AuthorizationService {
        return builder.build("https://api.coindesk.com/v1/bpi/currentprice.json/").create(AuthorizationService::class.java)
    }
}