package pl.nepapp.core.settings.localimpl

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.github.osipxd.security.crypto.encryptedPreferencesDataStore
import org.koin.core.annotation.Single
import pl.nepapp.core.settings.UserStorage

@Single
class UserStorageImpl(private val context: Context) : UserStorage {
    private val Context.dataStore by encryptedPreferencesDataStore(name = "user_storage")

    override suspend fun saveTokens(accessToken: String, refreshToken: String) {
        context.dataStore.edit { settings ->
            settings[ACCESS_TOKEN] = accessToken
            settings[REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun getAccessToken(): String? {
        return context.dataStore.get(ACCESS_TOKEN)
    }

    override suspend fun getRefreshToken(): String? {
        return context.dataStore.get(REFRESH_TOKEN)
    }

    override suspend fun clear() {
        context.dataStore.edit { settings ->
            settings.remove(ACCESS_TOKEN)
            settings.remove(REFRESH_TOKEN)
        }
    }

    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
    }
}