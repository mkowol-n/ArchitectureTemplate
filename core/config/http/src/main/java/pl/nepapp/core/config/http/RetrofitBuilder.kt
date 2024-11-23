package pl.nepapp.core.config.http

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.core.annotation.Factory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface RetrofitBuilder {
    fun build(url: String): Retrofit
}

@Factory
class RetrofitBuilderImpl(
    private val moshi: Moshi,
    private val okHttpClient: OkHttpClient
) : RetrofitBuilder {
    override fun build(url: String): Retrofit {
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(url)
            .client(okHttpClient).build()
    }
}