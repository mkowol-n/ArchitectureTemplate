package pl.nepapp.features.todolist.impl

import kotlinx.collections.immutable.ImmutableList
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized
import pl.nepapp.core.statemanagement.async
import pl.nepapp.core.statemanagement.asyncFlow
import pl.nepapp.data.todo.TodoRepository
import pl.nepapp.data.todo.TodoResponse

@KoinViewModel
class TodoListViewModel(
    private val todoRepository: TodoRepository
): BaseViewModel<TodoListViewModel.TodoListState, Unit>(TodoListState()) {
    data class TodoListState(
        val todoListRequest: Async<Unit> = Uninitialized,
        val todoListLocal: Async<ImmutableList<TodoResponse>> = Uninitialized
    )

    init {
        initialize()
    }

    fun again() {
        intent {
            async {
                todoRepository.getAll()
                Unit
            }.execute {
                state.copy(
                    todoListRequest = it
                )
            }
        }
    }
    private fun initialize() {

        again()

        intent(registerIdling = false) {
            asyncFlow(todoRepository.getAllFlow()).execute {
                state.copy(
                    todoListLocal = it
                )
            }
        }
    }
}