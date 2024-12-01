package pl.nepapp.core.config.http

import retrofit2.Retrofit

interface RetrofitBuilder {
    fun build(url: String): Retrofit
}