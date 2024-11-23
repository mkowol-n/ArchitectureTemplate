package pl.nepapp.core.navigation

import kotlin.reflect.KClass

interface  NavigationSavedStateHandle {
    fun <T : Direction> getDirecion(clazz: KClass<T>): T
}
