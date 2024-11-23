package pl.nepapp.core.config.http.impl

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.annotation.Single
import pl.nepapp.core.common.exceptions.NetworkException
import pl.nepapp.core.settings.local.UserStorage
import retrofit2.HttpException
import java.io.IOException

interface RequestInterceptor : Interceptor

@Single
class RequestInterceptorImpl(private val userStorage: UserStorage) : RequestInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val token = runBlocking {
            userStorage.getAccessToken()
        }

        val request = chain.request()

        val builder = request.newBuilder().apply {
            addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(builder.build())
    }
}