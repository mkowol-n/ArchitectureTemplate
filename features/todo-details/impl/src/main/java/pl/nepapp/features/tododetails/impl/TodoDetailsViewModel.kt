package pl.nepapp.features.tododetails.impl

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Scope
import org.koin.core.annotation.ScopeId
import org.koin.core.annotation.Scoped
import org.koin.core.component.createScope
import pl.nepapp.core.common.SomeOtherScope
import pl.nepapp.core.common.mainScope
import pl.nepapp.core.navigation.NavigationSavedStateHandle
import pl.nepapp.core.navigation.getDirection
import pl.nepapp.core.statemanagement.BaseScopeViewModel
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.data.todo.TodoRepository
import pl.nepapp.features.tododetails.TodoDetailsDirection

@KoinViewModel
@Scoped
@Scope(SomeOtherScope::class)
class TodoDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val todoRepository: TodoRepository
) : BaseViewModel<TodoDetailsViewModel.TodoDetailsState, Unit>(
    TodoDetailsState(
        directionModel = TodoDetailsDirection.from(savedStateHandle)
    )
) {
    data class TodoDetailsState(
        val directionModel: TodoDetailsDirection
    )

    init {
        Log.d("pizda2", todoRepository.hashCode().toString())
    }

    init {
//        viewModelScope.launch {
//            todoRepository.test.collect {
//                Log.d("pizda3", it.hashCode().toString())
//            }
//        }
//        viewModelScope.launch {
//            todoRepository.getAllFlow().collect {
//                Log.d("pizda4", it.hashCode().toString())
//            }
//        }
    }
}
