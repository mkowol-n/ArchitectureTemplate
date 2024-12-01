package pl.nepapp.core.config.http.impl

import okhttp3.OkHttpClient

class OkHttpBuilderSteps {
    private val builderSteps = mutableListOf<IOkHttpBuilderStep>()

    @Suppress("unused")
    fun addBuilder(okHttpBuilder: IOkHttpBuilderStep) {
        builderSteps.add(okHttpBuilder)
    }

    fun applySteps(builder: OkHttpClient.Builder) {
        for (step in builderSteps) {
            step.addBuildStep(builder)
        }
    }

    companion object {
        val INSTANCE =
            OkHttpBuilderSteps()
    }
}

interface IOkHttpBuilderStep {
    fun addBuildStep(builder: OkHttpClient.Builder)
}
