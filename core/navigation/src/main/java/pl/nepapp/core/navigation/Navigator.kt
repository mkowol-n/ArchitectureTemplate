package pl.nepapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

interface Navigator {
    val parent: Navigator

    fun replaceAll(directions: List<Direction>)

    fun replaceAll(direction: Direction)

    fun replace(directions: List<Direction>)

    fun replace(direction: Direction)

    fun push(directions: List<Direction>)

    fun push(direction: Direction)

    fun pop()

    fun popWithResult(value: Pair<String, Any?>)

    @Composable
    fun <T> getResult(screenKey: String): State<T?>
}