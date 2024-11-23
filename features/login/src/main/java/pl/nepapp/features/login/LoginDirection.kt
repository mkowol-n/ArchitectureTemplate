package pl.nepapp.features.login

import kotlinx.serialization.Serializable
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.api.ScreenRegistry

@Serializable
object LoginDirection: Direction

abstract class LoginScreenRegistry: ScreenRegistry<LoginDirection>()