package pl.nepapp.infrastructure.http.impl

import org.koin.core.annotation.Single
import pl.nepapp.core.common.exceptions.NetworkException
import pl.nepapp.infrastructure.http.NetworkResponseConverter
import retrofit2.HttpException
import java.io.IOException

@Single
class NetworkResponseConverterImpl: NetworkResponseConverter {
    override suspend operator fun <T, S> invoke(call: suspend () -> T, callBack: (T) -> S): S {
        try {
            return callBack(call())
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