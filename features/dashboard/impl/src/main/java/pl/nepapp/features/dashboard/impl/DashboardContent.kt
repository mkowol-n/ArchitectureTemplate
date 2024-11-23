package pl.nepapp.features.dashboard.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.annotation.Factory
import pl.nepapp.coreui.Displaytype
import pl.nepapp.coreui.bottomNavigation.NepappBottomNavigation
import pl.nepapp.coreui.bottomNavigation.NepappBottomNavigationModel
import pl.nepapp.features.dashboard.DashboardScreenRegistry
import pl.nepapp.features.dashboard.impl.models.BottomNavOptions
import pl.nepapp.navigation.impl.LocalNavigator

@Factory
class DashboardScreen : DashboardScreenRegistry() {
    @Composable
    override fun Content() {
        DashboardContent()
    }
}

@Composable
internal fun DashboardContent() {
    val navigator = LocalNavigator.current

    val bottomNavOptions = remember {
        BottomNavOptions.entries.map {
            NepappBottomNavigationModel(
                displaytype = Displaytype.Text(it.text),
                item = it,
            )
        }.toImmutableList()
    }

    var bottomNavSelectedOption by rememberSaveable {
        mutableStateOf(bottomNavOptions.first().item)
    }

    Scaffold(
        bottomBar = {
            NepappBottomNavigation(
                onClick = { newBottomItem ->
                    bottomNavSelectedOption = newBottomItem
                },
                selectedItem = bottomNavSelectedOption,
                items = bottomNavOptions
            )
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            when(bottomNavSelectedOption) {
                BottomNavOptions.Todo -> {

                }
                BottomNavOptions.Account -> {

                }
            }
        }
    }
}