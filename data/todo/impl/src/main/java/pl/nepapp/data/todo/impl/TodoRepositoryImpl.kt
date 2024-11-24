package pl.nepapp.data.todo.impl

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import pl.nepapp.data.todo.TodoRepository
import pl.nepapp.data.todo.TodoResponse
import pl.nepapp.data.todo.local.TodoDao
import pl.nepapp.data.todo.local.TodoEntity
import java.util.UUID

private var thrown = false

class TodoRepositoryImpl(private val todoDao: TodoDao) : TodoRepository {

    override suspend fun getAll(): ImmutableList<TodoResponse> {
        delay(2000)
        if(!thrown) {
            thrown = true
            throw Exception()
        } else {
            insertAll(
                listOf(
                    TodoResponse(
                        id = UUID.randomUUID().toString(),
                        title = UUID.randomUUID().toString(),
                        description = UUID.randomUUID().toString()
                    )
                )
            )
        }
        return todoDao.getAll().map { entity ->
            TodoResponse(
                id = entity.id,
                title = entity.title,
                description = entity.description
            )
        }.toImmutableList()
    }

    override fun getAllFlow(): Flow<ImmutableList<TodoResponse>> {
        return todoDao.getAllFlow().map {
            it.map { entity ->
                TodoResponse(
                    id = entity.id,
                    title = entity.title,
                    description = entity.description
                )
            }.toImmutableList()
        }
    }

    override suspend fun insertAll(todos: List<TodoResponse>) {
        todoDao.insertAll(
            todos.map { model ->
                TodoEntity(
                    id = model.id,
                    title = model.title,
                    description = model.description
                )
            }
        )
    }
}