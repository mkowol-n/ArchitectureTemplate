package pl.nepapp.data.todo

import kotlinx.serialization.Serializable

@Serializable
data class TodoResponse(
    val id: String,
    val title: String,
    val description: String,
)
