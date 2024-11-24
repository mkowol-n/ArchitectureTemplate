package pl.nepapp.data.todo

import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun getAll(): ImmutableList<TodoResponse>

    fun getAllFlow(): Flow<ImmutableList<TodoResponse>>

    suspend fun insertAll(todos: List<TodoResponse>)
}