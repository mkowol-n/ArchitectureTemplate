package pl.nepapp.core.navigation

import androidx.navigation.NavType
import kotlin.reflect.KClass
import kotlin.reflect.KType

interface NavigationSavedStateHandle {
    fun <T : Direction> getDirecion(
        clazz: KClass<T>,
        typeMap: Map<KType, @JvmSuppressWildcards NavType<*>>
    ): T
}
