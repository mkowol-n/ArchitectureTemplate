package pl.nepapp.main

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import pl.nepapp.navigation.NepAppGraph

@Composable
fun MainScreen() {
    MainContent()
}

@Composable
internal fun MainContent(nepAppGraph: NepAppGraph = koinInject()) {
    nepAppGraph.Route()
}