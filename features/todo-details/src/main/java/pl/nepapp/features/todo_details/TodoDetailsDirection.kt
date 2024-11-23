package pl.nepapp.features.todo_details

import kotlinx.serialization.Serializable
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.api.ScreenRegistry

@Serializable
data class TodoDetailsDirection(val id: String): Direction

abstract class TodoDetailsScreenRegistry: ScreenRegistry<TodoDetailsDirection>()