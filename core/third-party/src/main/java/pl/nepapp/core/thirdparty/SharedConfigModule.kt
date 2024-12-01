package pl.nepapp.core.thirdparty

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class SharedConfigModule() {

    @Single
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}