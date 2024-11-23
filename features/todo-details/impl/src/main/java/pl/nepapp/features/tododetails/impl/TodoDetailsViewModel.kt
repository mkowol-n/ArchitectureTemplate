package pl.nepapp.features.tododetails.impl

import android.util.Log
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.navigation.NavigationSavedStateHandle
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.features.tododetails.TodoDetailsDirection

@KoinViewModel
class TodoDetailsViewModel(
    savedStateHandle: NavigationSavedStateHandle
) : BaseViewModel<TodoDetailsViewModel.TodoDetailsState, Unit>(
    TodoDetailsState(
        directionModel = savedStateHandle.getDirecion(TodoDetailsDirection::class)
    )
) {
    data class TodoDetailsState(
        val directionModel: TodoDetailsDirection
    )

}
