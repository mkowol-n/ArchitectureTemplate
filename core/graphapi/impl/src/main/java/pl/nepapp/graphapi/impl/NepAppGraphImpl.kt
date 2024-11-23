package pl.nepapp.graphapi.impl

import androidx.compose.runtime.Composable
import org.koin.core.annotation.Single
import pl.nepapp.features.account.AccountDirection
import pl.nepapp.features.account.impl.AccountContent
import pl.nepapp.features.dashboard.DashboardDirection
import pl.nepapp.features.dashboard.impl.DashboardContent
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.login.impl.LoginContent
import pl.nepapp.features.todo_details.TodoDetailsDirection
import pl.nepapp.features.todolist.TodoListDirection
import pl.nepapp.features.todolist.impl.TodoListContent
import pl.nepapp.graphapi.NepAppGraph

@Single
class NepAppGraphImpl: NepAppGraph {

    @Composable
    override fun Route() {
        BaseNavHost(
            startDestination = LoginDirection,
        ) {
            registerWithSlideAnimation<LoginDirection> {
                LoginContent()
            }
            registerWithSlideAnimation<DashboardDirection> {
                DashboardContent()
            }
        }
    }

    @Composable
    override fun TodoRoute() {
        BaseNavHost(
            startDestination = TodoListDirection,
        ) {
            registerWithSlideAnimation<TodoListDirection> {
                TodoListContent()
            }
            registerWithSlideAnimation<TodoDetailsDirection> {
                TodoListContent()
            }
        }
    }

    @Composable
    override fun AccountRoute() {
        BaseNavHost(
            startDestination = AccountDirection,
        ) {
            registerWithSlideAnimation<AccountDirection> {
                AccountContent()
            }
        }
    }
}
