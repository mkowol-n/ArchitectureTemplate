package pl.nepapp.core.common.exceptions

class HttpException(
    val code: Int,
    message: String
): Throwable(message = message)