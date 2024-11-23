package pl.nepapp.features.dashboard.impl

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.toImmutableList
import org.koin.compose.koinInject
import pl.nepapp.coreui.DisplayType
import pl.nepapp.coreui.bottomNavigation.NepappBottomNavigation
import pl.nepapp.coreui.bottomNavigation.NepappBottomNavigationModel
import pl.nepapp.features.dashboard.impl.models.BottomNavOptions
import pl.nepapp.navigation.LocalNavigator
import pl.nepapp.navigation.NepAppGraph

@Composable
fun DashboardContent(nepAppGraph: NepAppGraph = koinInject()) {
    val navigator = LocalNavigator.current

    val bottomNavOptions = remember {
        BottomNavOptions.entries.map {
            NepappBottomNavigationModel(
                displaytype = DisplayType.Text(it.text),
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
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AnimatedContent(
                bottomNavSelectedOption, label = "", transitionSpec = {
                    fadeIn().togetherWith(fadeOut())
                }
            ) { selected ->
                when (selected) {
                    BottomNavOptions.Todo -> {
                        nepAppGraph.TodoRoute()
                    }

                    BottomNavOptions.Account -> {
                        nepAppGraph.AccountRoute()
                    }
                }
            }
        }
    }
}