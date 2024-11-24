package pl.nepapp.usecases.combined.impl

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import pl.nepapp.usecases.combined.CombinedUseCase


val combinedUseCaseModule = module {
    factoryOf<CombinedUseCase>(::CombinedUseCaseImpl)
}