package pl.nepapp.core.settings.localimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.firstOrNull

suspend fun <T> DataStore<Preferences>.get(key: Preferences.Key<T> ): T? {
    val values =  data.firstOrNull() ?: return null
    return values[key]
}