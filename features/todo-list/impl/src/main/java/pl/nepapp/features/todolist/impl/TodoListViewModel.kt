package pl.nepapp.features.todolist.impl

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.Koin
import org.koin.core.annotation.Scope
import org.koin.core.annotation.ScopeId
import org.koin.core.annotation.Scoped
import org.koin.core.component.KoinComponent
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.getOrCreateScope
import org.koin.core.component.getScopeName
import org.koin.core.component.getScopeOrNull
import org.koin.core.context.GlobalContext
import org.koin.core.context.KoinContext
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import pl.nepapp.core.common.SomeOtherScope
import pl.nepapp.core.common.mainScope
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.BaseScopeViewModel
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized
import pl.nepapp.core.statemanagement.async
import pl.nepapp.core.statemanagement.asyncFlow
import pl.nepapp.data.todo.TodoRepository
import pl.nepapp.data.todo.TodoResponse

@KoinViewModel
class TodoListViewModel(
): BaseScopeViewModel<TodoListViewModel.TodoListState, Unit>(TodoListState(), mainScope) {
    private val todoRepository: TodoRepository by scope.inject()
    data class TodoListState(
        val todoListRequest: Async<Unit> = Uninitialized,
        val todoListLocal: Async<ImmutableList<TodoResponse>> = Uninitialized
    )


    init {
        Log.d("pizda2", todoRepository.daoHasCode)
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