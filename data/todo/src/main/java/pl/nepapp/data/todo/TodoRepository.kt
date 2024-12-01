package pl.nepapp.data.todo

import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

class TestClass(
    val testValue: String
)

interface TodoRepository {
    suspend fun getAll(): ImmutableList<TodoResponse>

    fun getAllFlow(): Flow<ImmutableList<TodoResponse>>

    suspend fun insertAll(todos: List<TodoResponse>)

    val test: Flow<TestClass>

    val daoHasCode: String
}