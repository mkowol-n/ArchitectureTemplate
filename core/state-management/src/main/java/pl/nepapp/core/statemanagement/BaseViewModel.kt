package pl.nepapp.core.statemanagement

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import org.koin.androidx.scope.ScopeViewModel
import org.koin.core.component.createScope
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.core.scope.ScopeID
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel<STATE : Any, SIDE_EFFECT : Any>(initialState: STATE) :
    ContainerHost<STATE, SIDE_EFFECT>, ViewModel() {
    override val container = container<STATE, SIDE_EFFECT>(initialState)
}

abstract class BaseScopeViewModel<STATE : Any, SIDE_EFFECT : Any>(
    initialState: STATE,
    private val scopeName: String
) :
    ContainerHost<STATE, SIDE_EFFECT>, ScopeViewModel() {
    override val container = container<STATE, SIDE_EFFECT>(initialState)
    override val scope: Scope
        get() = getKoin().createScope(
            scopeId = scopeName,
            qualifier = named(scopeName)
        )
}