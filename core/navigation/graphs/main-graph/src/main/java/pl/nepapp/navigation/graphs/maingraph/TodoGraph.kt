package pl.nepapp.navigation.graphs.maingraph

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.todo_details.TodoDetailsScreenRegistry
import pl.nepapp.features.todolist.TodoListScreenRegistry
import pl.nepapp.navigation.graphs.base.BaseNavHost
import pl.nepapp.navigation.graphs.base.registerWithSlideAnimation

@Composable
fun TodoGraph(
    todoListScreenRegistry: TodoListScreenRegistry = koinInject(),
    todoDetailsScreenRegistry: TodoDetailsScreenRegistry = koinInject(),
) {
    BaseNavHost(
        startDestination = LoginDirection
    ) {
        todoListScreenRegistry.registerWithSlideAnimation(navGraphBuilder = this@BaseNavHost)
        todoDetailsScreenRegistry.registerWithSlideAnimation(navGraphBuilder = this@BaseNavHost)
    }
}