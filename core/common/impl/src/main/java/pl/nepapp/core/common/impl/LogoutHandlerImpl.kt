package pl.nepapp.core.common.impl

import org.koin.core.annotation.Single
import pl.nepapp.core.common.handlers.LogoutHandler

@Single
class LogoutHandlerImpl: LogoutHandler {
    override suspend fun logout() {

    }
}