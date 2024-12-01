package pl.nepapp.core.statemanagement

import androidx.lifecycle.ViewModel
import org.koin.androidx.scope.ScopeViewModel
import org.koin.core.scope.Scope
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel<STATE : Any, SIDE_EFFECT : Any>(initialState: STATE) :
    ContainerHost<STATE, SIDE_EFFECT>, ViewModel() {
    override val container = container<STATE, SIDE_EFFECT>(initialState)
}

abstract class BaseScopeViewModel<STATE : Any, SIDE_EFFECT : Any, out SCOPE: Any>(
    initialState: STATE,
) :
    ContainerHost<STATE, SIDE_EFFECT>, ScopeViewModel() {
    override val container = container<STATE, SIDE_EFFECT>(initialState)
    abstract override val scope: Scope

    inline fun <reified T: Any> provideScope(): Scope {
        return getKoin().createScope<T>(scopeId = T::class.java.simpleName, source = T::class)
    }

}