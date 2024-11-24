package pl.nepapp.features.tododetails

import kotlinx.serialization.Serializable
import pl.nepapp.core.navigation.Direction
import pl.nepapp.core.navigation.NavigationSavedStateHandle
import pl.nepapp.core.navigation.serializableType
import pl.nepapp.data.todo.TodoResponse
import kotlin.reflect.typeOf

@Serializable
data class TodoDetailsDirection(
    val todo: TodoResponse
): Direction {

    companion object {
        val typeMap = mapOf(typeOf<TodoResponse>() to serializableType<TodoResponse>())

        fun from(savedStateHandle: NavigationSavedStateHandle): TodoDetailsDirection {
            return savedStateHandle.getDirecion(
                TodoDetailsDirection::class,
                typeMap
            )
        }
    }
}