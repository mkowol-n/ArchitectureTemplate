package pl.nepapp.core.navigation.impl

import androidx.compose.runtime.Composable
import org.koin.core.annotation.Single
import pl.nepapp.features.account.AccountDirection
import pl.nepapp.features.account.impl.AccountScreen
import pl.nepapp.features.dashboard.DashboardDirection
import pl.nepapp.features.dashboard.impl.DashboardContent
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.login.impl.LoginScreen
import pl.nepapp.features.tododetails.TodoDetailsDirection
import pl.nepapp.features.tododetails.impl.TodoDetailsScreen
import pl.nepapp.features.todolist.TodoListDirection
import pl.nepapp.features.todolist.impl.TodoListContent
import pl.nepapp.core.navigation.NepAppGraph

@Single
class NepAppGraphImpl: NepAppGraph {

    @Composable
    override fun Route() {
        BaseNavHost(
            startDestination = LoginDirection,
        ) {
            registerWithSlideAnimation<LoginDirection> {
                LoginScreen()
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
                TodoDetailsScreen()
            }
        }
    }

    @Composable
    override fun AccountRoute() {
        BaseNavHost(
            startDestination = AccountDirection,
        ) {
            registerWithSlideAnimation<AccountDirection> {
                AccountScreen()
            }
        }
    }
}
