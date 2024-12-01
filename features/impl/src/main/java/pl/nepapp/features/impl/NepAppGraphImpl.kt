package pl.nepapp.features.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.koin.compose.getKoin
import org.koin.compose.scope.KoinScope
import org.koin.compose.scope.rememberKoinScope
import org.koin.core.qualifier.StringQualifier
import pl.nepapp.core.navigation.impl.BaseNavHost
import pl.nepapp.core.navigation.impl.registerWithNewSlideAnimation
import pl.nepapp.features.NepAppGraph
import pl.nepapp.features.account.AccountDirection
import pl.nepapp.features.account.impl.AccountScreen
import pl.nepapp.features.dashboard.DashboardDirection
import pl.nepapp.features.dashboard.impl.DashboardScreen
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.login.impl.LoginScreen
import pl.nepapp.features.tododetails.TodoDetailsDirection
import pl.nepapp.features.tododetails.impl.TodoDetailsScreen
import pl.nepapp.features.todolist.TodoListDirection
import pl.nepapp.features.todolist.impl.TodoListContent

class NepAppGraphImpl: NepAppGraph {

    @Composable
    override fun MainRoute(navHostController: NavHostController, initialScreenIsLogin: Boolean) {
        BaseNavHost(
            startDestination = if(initialScreenIsLogin) LoginDirection else DashboardDirection ,
            navController = navHostController
        ) {
            registerWithNewSlideAnimation<LoginDirection> {
                LoginScreen()
            }
            registerWithNewSlideAnimation<DashboardDirection> {
                DashboardScreen()
            }
        }
    }

    @Composable
    override fun TodoRoute() {
       // KoinScope<MainScopes>(scopeID = "MainScope") {
            BaseNavHost(
                startDestination = TodoListDirection,
            ) {
                registerWithNewSlideAnimation<TodoListDirection> {
                    TodoListContent()
                }
                registerWithNewSlideAnimation<TodoDetailsDirection>(
                    typeMap = TodoDetailsDirection.typeMap
                ) {
                    TodoDetailsScreen()
                }
           }
      //  }
    }

    @Composable
    override fun AccountRoute() {
        BaseNavHost(
            startDestination = AccountDirection,
        ) {
            registerWithNewSlideAnimation<AccountDirection> {
                AccountScreen()
            }
        }
    }
}
