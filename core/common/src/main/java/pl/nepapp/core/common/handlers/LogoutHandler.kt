package pl.nepapp.core.common.handlers

import kotlinx.coroutines.flow.Flow

interface LogoutHandler {
    val logoutFlow: Flow<Unit>
    suspend fun logout()
}