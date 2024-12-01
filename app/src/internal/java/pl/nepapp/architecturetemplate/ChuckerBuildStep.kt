package pl.nepapp.architecturetemplate

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import pl.nepapp.core.config.http.impl.IOkHttpBuilderStep

class ChuckerBuilderStep(
    private val context: Context,
    private val chuckerCollector: ChuckerCollector,
) :
    IOkHttpBuilderStep {
    override fun addBuildStep(builder: OkHttpClient.Builder) {
        builder.addInterceptor(
            ChuckerInterceptor.Builder(context)
                .collector(
                    collector = chuckerCollector
                )
                .alwaysReadResponseBody(true)
                .build()
        )
    }
}
