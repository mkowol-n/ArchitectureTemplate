package pl.nepapp.features.tododetails

import kotlinx.serialization.Serializable
import pl.nepapp.core.navigation.Direction
import pl.nepapp.data.todo.TodoResponse

@Serializable
data class TodoDetailsDirection(val todo: TodoResponse): Direction