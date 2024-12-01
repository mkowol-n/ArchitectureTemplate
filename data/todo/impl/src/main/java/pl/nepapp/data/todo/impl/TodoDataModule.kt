package pl.nepapp.data.todo.impl

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.scopedOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import pl.nepapp.core.common.FinalScope
import pl.nepapp.core.common.SomeOtherScope
import pl.nepapp.core.common.mainScope
import pl.nepapp.data.todo.TestClass
import pl.nepapp.data.todo.TodoRepository
import pl.nepapp.data.todo.TodoResponse
import pl.nepapp.data.todo.local.TodoDao

val todoDataModule = module {

    scope< FinalScope> {
        scopedOf(::TodoRepositoryImpl) bind TodoRepository::class
    }

    scope<SomeOtherScope> {
        scopedOf(::TodoRepositoryImpl) bind TodoRepository::class
    }
}