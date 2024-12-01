package pl.nepapp.core.config.http.impl

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.core.annotation.Factory
import pl.nepapp.core.config.http.RetrofitBuilder
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Factory
class RetrofitBuilderImpl(
    private val moshi: Moshi,
    private val okHttpClient: OkHttpClient
) : RetrofitBuilder {
    override fun build(url: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory
            .create(moshi))
            .baseUrl(url)
            .client(okHttpClient).build()
    }
}