package pl.nepapp.infrastructure.http

interface NetworkResponseConverter {
    suspend operator fun <T, S> invoke(call: suspend () -> T, callBack: (T) -> S): S
}