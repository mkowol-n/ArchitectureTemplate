package pl.nepapp.navigation.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import pl.nepapp.navigation.Navigator

class NavigatorImpl(private val _parent: Navigator?, private val navigator: NavController): Navigator {
    private val results = mutableStateMapOf<String, Any?>()
    override val parent: Navigator get() = requireNotNull(_parent)

    override fun replaceAll(directions: List<pl.nepapp.navigation.Direction>) {
        directions.forEachIndexed { index, direction ->
            if (index == 0) {
                navigator.navigate(direction) {
                    popUpTo(navigator.graph.startDestinationId) { inclusive = true }
                }
            } else {
                navigator.navigate(direction)
            }
        }
    }

    override fun replaceAll(direction: pl.nepapp.navigation.Direction) {
        navigator.navigate(direction) {
            popUpTo(navigator.graph.startDestinationId) { inclusive = true }
        }
    }

    override fun replace(directions: List<pl.nepapp.navigation.Direction>) {
        directions.forEachIndexed { index, direction ->
            if (index == 0) {
                navigator.navigate(direction) {
                    popUpTo(navigator.graph.last().id)
                }
            } else {
                navigator.navigate(direction)
            }
        }
    }

    override fun replace(direction: pl.nepapp.navigation.Direction) {
        navigator.navigate(direction) {
            popUpTo(navigator.graph.last().id)
        }
    }

    override fun push(directions: List<pl.nepapp.navigation.Direction>) {
        directions.forEach {
            navigator.navigate(it)
        }
    }

    override fun push(direction: pl.nepapp.navigation.Direction) {
        navigator.navigate(direction)
    }

    override fun pop() {
        navigator.popBackStack()
    }

    override fun popWithResult(value: Pair<String, Any?>) {
        results[value.first] = value.second
        navigator.popBackStack()
    }

    @Composable
    override fun <T> getResult(screenKey: String): State<T?> {
        @Suppress("UNCHECKED_CAST") val result = results[screenKey] as? T
        val resultState = remember(screenKey, result) {
            derivedStateOf {
                results.remove(screenKey)
                result
            }
        }
        return resultState
    }
}