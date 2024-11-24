package pl.nepapp.core.navigation.impl

import android.annotation.SuppressLint
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.internalToRoute
import org.koin.core.annotation.Factory
import pl.nepapp.core.navigation.Direction
import pl.nepapp.core.navigation.NavigationSavedStateHandle
import kotlin.reflect.KClass

@Factory
class NavigationSavedStateHandleImpl(
    val savedStateHandle: SavedStateHandle
) : NavigationSavedStateHandle {

    @SuppressLint("RestrictedApi")
    override fun <T : Direction> getDirecion(clazz: KClass<T>): T {
        return savedStateHandle.internalToRoute(route = clazz, typeMap = emptyMap())
    }
}

