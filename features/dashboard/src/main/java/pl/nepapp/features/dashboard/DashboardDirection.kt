package pl.nepapp.features.dashboard

import kotlinx.serialization.Serializable
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.api.ScreenRegistry

@Serializable
object DashboardDirection: Direction

abstract class DashboardScreenRegistry: ScreenRegistry<DashboardDirection>()

