package pl.nepapp.features.tododetails

import kotlinx.serialization.Serializable
import pl.nepapp.core.navigation.Direction

@Serializable
data class TodoDetailsDirection(val id: String): Direction