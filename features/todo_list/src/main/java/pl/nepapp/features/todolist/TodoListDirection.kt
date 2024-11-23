package pl.nepapp.features.todolist

import kotlinx.serialization.Serializable
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.api.ScreenRegistry

@Serializable
object TodoListDirection: Direction

abstract class TodoListScreenRegistry: ScreenRegistry<TodoListDirection>()