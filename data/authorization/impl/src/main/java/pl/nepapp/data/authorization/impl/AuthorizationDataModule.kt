package pl.nepapp.data.authorization.impl

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import pl.nepapp.data.authorization.AuthorizationRepository

val authorizationDataModule = module {
    factoryOf(::AuthorizationRepositoryImpl) bind AuthorizationRepository::class
}