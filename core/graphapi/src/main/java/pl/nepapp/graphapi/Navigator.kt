package pl.nepapp.graphapi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap

interface Navigator {
    val parent: Navigator

    fun replaceAll(directions: List<Direction>)

    fun replaceAll(direction: Direction)

    fun replace(directions: List<Direction>)

    fun replace(direction: pl.nepapp.graphapi.Direction)

    fun push(directions: List<pl.nepapp.graphapi.Direction>)

    fun push(direction: pl.nepapp.graphapi.Direction)

    fun pop()

    fun popWithResult(value: Pair<String, Any?>)

    @Composable
    fun <T> getResult(screenKey: String): State<T?>
}