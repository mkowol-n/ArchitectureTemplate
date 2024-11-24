package pl.nepapp.core.navigation.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import pl.nepapp.core.navigation.Direction
import pl.nepapp.core.navigation.Navigator

class NavigatorImpl(private val _parent: Navigator?, private val navController: NavController) :
    Navigator {
    private val results = mutableStateMapOf<String, Any?>()
    override val parent: Navigator get() = requireNotNull(_parent)

    override fun replaceAll(directions: List<Direction>) {
        directions.forEachIndexed { index, direction ->
            if (index == 0) {
                replaceAll(direction)
            } else {
                navController.navigate(direction)
            }
        }
    }

    override fun replaceAll(direction: Direction) {
        navController.navigate(direction) {
            popUpTo(0) {
                inclusive = true
            }
        }
    }

    override fun replace(directions: List<Direction>) {
        directions.forEachIndexed { index, direction ->
            if (index == 0) {
                navController.navigate(direction) {
                    popUpTo(navController.graph.last().id)
                }
            } else {
                navController.navigate(direction)
            }
        }
    }

    override fun replace(direction: Direction) {
        navController.navigate(direction) {
            popUpTo(navController.graph.last().id)
        }
    }

    override fun push(directions: List<Direction>) {
        directions.forEach {
            navController.navigate(it)
        }
    }

    override fun push(direction: Direction) {
        navController.navigate(direction)
    }

    override fun pop() {
        navController.popBackStack()
    }

    override fun popWithResult(value: Pair<String, Any?>) {
        results[value.first] = value.second
        navController.popBackStack()
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