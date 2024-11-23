package pl.nepapp.features.account

import kotlinx.serialization.Serializable
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.api.ScreenRegistry

@Serializable
object AccountDirection: Direction

abstract class AccountScreenRegistry: ScreenRegistry<AccountDirection>()