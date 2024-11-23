package pl.nepapp.data.authorization.impl

import org.koin.dsl.bind
import org.koin.dsl.module
import pl.nepapp.data.authorization.AuthorizationRepository

val authorizationDataModule = module {
    factory { AuthorizationRepositoryImpl(get()) } bind AuthorizationRepository::class
}