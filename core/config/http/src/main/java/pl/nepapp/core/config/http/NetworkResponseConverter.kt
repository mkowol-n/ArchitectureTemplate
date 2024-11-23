package pl.nepapp.core.config.http

interface NetworkResponseConverter {
    suspend operator fun <T, S> invoke(call: suspend () -> T, callBack: (T) -> S): S
}