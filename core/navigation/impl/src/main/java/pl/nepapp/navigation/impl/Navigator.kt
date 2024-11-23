package pl.nepapp.navigation.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import pl.nepapp.navigation.api.Direction

class Navigator(val parent: Navigator?, private val navigator: NavController) {
    private val results = mutableStateMapOf<String, Any?>()

    fun replaceAll(directions: List<Direction>) {
        directions.forEachIndexed { index, direction ->
            if(index == 0) {
                navigator.navigate(direction) {
                    popUpTo(navigator.graph.startDestinationId) { inclusive = true }
                }
            } else {
                navigator.navigate(direction)
            }
        }
    }
    fun replaceAll(direction: Direction) {
        navigator.navigate(direction) {
            popUpTo(navigator.graph.startDestinationId) { inclusive = true }
        }
    }

    fun replace(directions: List<Direction>) {
        directions.forEachIndexed { index, direction ->
            if(index == 0) {
                navigator.navigate(direction) {
                    popUpTo(navigator.graph.last().id)
                }
            } else {
                navigator.navigate(direction)
            }
        }
    }

    fun replace(direction: Direction) {
        navigator.navigate(direction) {
            popUpTo(navigator.graph.last().id)
        }
    }

    fun push(directions: List<Direction>) {
        directions.forEach {
            navigator.navigate(it)
        }
    }

    fun push(direction: Direction) {
        navigator.navigate(direction)
    }

    fun pop() {
        navigator.popBackStack()
    }

    fun popWithResult(value: Pair<String, Any?>) {
        results[value.first] = value.second
        navigator.popBackStack()
    }

    @Composable
    fun <T> getResult(screenKey: String): State<T?> {
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