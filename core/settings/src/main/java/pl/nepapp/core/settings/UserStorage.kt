package pl.nepapp.core.settings

interface UserStorage {
    suspend fun saveTokens(accessToken: String, refreshToken: String)
    suspend fun getAccessToken(): String?

    suspend fun getRefreshToken(): String?

    suspend fun clear()
}