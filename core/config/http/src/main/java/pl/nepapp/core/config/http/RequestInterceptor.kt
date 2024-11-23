package pl.nepapp.core.config.http

import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.annotation.Single

interface RequestInterceptor: Interceptor

@Single
class RequestInterceptorImpl: RequestInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = "" //TODO

        val request = chain.request()

        val builder = request.newBuilder().apply {
            addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(builder.build())
    }
}