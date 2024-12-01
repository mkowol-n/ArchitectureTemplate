package pl.nepapp.architecturetemplate

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.RetentionManager
import pl.nepapp.core.config.http.impl.OkHttpBuilderSteps



class InternalApplication : MainApplication() {

    override fun setupDevTools() {
        val builderSteps = OkHttpBuilderSteps.INSTANCE

        val chuckerCollector = ChuckerCollector(
            context = applicationContext,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_DAY
        )
        builderSteps.addBuilder(ChuckerBuilderStep(applicationContext, chuckerCollector))

    }
}
