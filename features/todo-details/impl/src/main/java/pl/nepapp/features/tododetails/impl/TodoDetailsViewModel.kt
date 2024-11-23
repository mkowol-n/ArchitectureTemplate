package pl.nepapp.features.tododetails.impl

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.statemanagement.BaseViewModel

@KoinViewModel
class TodoDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
): BaseViewModel<TodoDetailsViewModel.TodoDetailsState, Unit>(
    TodoDetailsState(
    id = savedStateHandle[savedStateHandle.keys().first()]!!
)
) {
    data class TodoDetailsState(
        val id: String
    )

    init {
        intent {
            Log.d("pizda", state.id)
            Log.d("pizda1", savedStateHandle.keys().first())
        }
    }
}