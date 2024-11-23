package pl.nepapp.features.main

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import pl.nepapp.core.navigation.NepAppGraph

@Composable
fun MainScreen() {
    MainContent()
}

@Composable
internal fun MainContent(nepAppGraph: NepAppGraph = koinInject()) {
    nepAppGraph.Route()
}