package pl.nepapp.data.todo.impl

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.getOrCreateScope
import org.koin.core.component.getScopeOrNull
import org.koin.core.component.inject
import org.koin.core.scope.Scope
import pl.nepapp.data.todo.TestClass
import pl.nepapp.data.todo.TodoRepository
import pl.nepapp.data.todo.TodoResponse
import pl.nepapp.data.todo.local.TodoDao
import pl.nepapp.data.todo.local.TodoEntity
import java.util.UUID

private var thrown = false

class TodoRepositoryImpl(
    private val todoDao: TodoDao
) : TodoRepository {


    override val test = MutableStateFlow(TestClass(
        "hello"
    ))
    override val daoHasCode: String = todoDao.hashCode().toString()

    override suspend fun getAll(): ImmutableList<TodoResponse> {
        delay(2000)
//        insertAll(
//            listOf(
//                TodoResponse(
//                    id = UUID.randomUUID().toString(),
//                    title = UUID.randomUUID().toString(),
//                    description = UUID.randomUUID().toString()
//                )
//            )
//        )
        throw Exception()
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
        }.filter {
            it.size > 3
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
