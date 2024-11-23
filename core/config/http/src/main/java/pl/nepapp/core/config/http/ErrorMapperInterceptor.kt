package pl.nepapp.core.config.http

import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.annotation.Single
import pl.nepapp.core.common.exceptions.NetworkException
import retrofit2.HttpException
import java.io.IOException

interface ErrorMapperInterceptor : Interceptor

@Single
class ErrorMapperInterceptorImpl : ErrorMapperInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            return chain.proceed(chain.request())
        } catch (e: Throwable) {
            when (e) {
                is IOException -> {
                    throw NetworkException()
                }

                is HttpException -> {
                    throw pl.nepapp.core.common.exceptions.HttpException(
                        code = e.code(),
                        message = e.message()
                    )
                }

                else -> throw e
            }
        }
    }
}