package pl.nepapp.data.todo.impl

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import pl.nepapp.data.todo.TodoRepository

val todoDataModule = module {
    factoryOf(::TodoRepositoryImpl) bind TodoRepository::class
}