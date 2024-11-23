package pl.nepapp.features.todo_details

import kotlinx.serialization.Serializable
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.api.ScreenRegistry

@Serializable
object TodoDetailsDirection: Direction

abstract class TodoDetailsScreenRegistry: ScreenRegistry<TodoDetailsDirection>()