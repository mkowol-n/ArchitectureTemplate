package pl.nepapp.architecturetemplate.providers

import org.koin.core.annotation.Single
import pl.nepapp.architecturetemplate.BuildConfig
import pl.nepapp.core.settings.BuildConfigProvider

@Single
class BuildConfigProviderImpl: BuildConfigProvider {
    override val baseUrl: String= BuildConfig.BASE_URL
}