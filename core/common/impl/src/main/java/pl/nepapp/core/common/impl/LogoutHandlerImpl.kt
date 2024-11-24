package pl.nepapp.core.common.impl

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.annotation.Single
import pl.nepapp.core.common.handlers.LogoutHandler
import pl.nepapp.core.settings.UserStorage

@Single
class LogoutHandlerImpl(
    private val userStorage: UserStorage,
): LogoutHandler {
    private val logoutEvent = Channel<Unit>()
    override val logoutFlow = logoutEvent.receiveAsFlow()

    override suspend fun logout() {
        userStorage.clear()
        logoutEvent.send(Unit)
    }
}