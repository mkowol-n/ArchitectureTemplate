package pl.nepapp.core.navigation

import android.annotation.SuppressLint
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.internalToRoute
import androidx.navigation.toRoute
import kotlin.reflect.KClass
import kotlin.reflect.KType

@SuppressLint("RestrictedApi")
inline fun <reified T: Direction> SavedStateHandle.getDirection(clazz: KClass<T>, typeMap: Map<KType, NavType<*>>): T {
    return this.internalToRoute(route = clazz, typeMap = typeMap)
}