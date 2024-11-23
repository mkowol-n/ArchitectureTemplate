package pl.nepapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

interface Navigator {
    val parent: Navigator

    fun replaceAll(directions: List<Direction>)

    fun replaceAll(direction: Direction)

    fun replace(directions: List<Direction>)

    fun replace(direction: pl.nepapp.navigation.Direction)

    fun push(directions: List<pl.nepapp.navigation.Direction>)

    fun push(direction: pl.nepapp.navigation.Direction)

    fun pop()

    fun popWithResult(value: Pair<String, Any?>)

    @Composable
    fun <T> getResult(screenKey: String): State<T?>
}