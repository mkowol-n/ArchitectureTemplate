package pl.nepapp.core.settings.local.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import java.lang.reflect.TypeVariable

suspend fun <T> DataStore<Preferences>.get(key: Preferences.Key<T> ): T? {
    val values =  data.firstOrNull() ?: return null
    return values[key]
}