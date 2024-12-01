package pl.nepapp.infrastructure.database

import android.content.Context
import androidx.room.Room
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Scope
import org.koin.core.annotation.ScopeId
import org.koin.core.annotation.Scoped
import org.koin.core.annotation.Single
import pl.nepapp.core.common.SomeOtherScope
import pl.nepapp.core.common.mainScope
import pl.nepapp.data.todo.local.TodoDao

@Module
@ComponentScan("pl.nepapp.infrastructure.database")
class DatabaseModule {

    @Factory
    @Scoped
    @Scope(name = mainScope)
    fun provideDatabase(context: Context): NepAppDatabase {
        return Room.databaseBuilder(
            context = context,
            NepAppDatabase::class.java, "nepapp-database"
        ).build()
    }

    @Factory
    @Scoped
    @Scope(SomeOtherScope::class)
    fun provideDatabaseOther(context: Context): NepAppDatabase {
        return Room.databaseBuilder(
            context = context,
            NepAppDatabase::class.java, "nepapp-database"
        ).build()
    }

    @Factory
    @Scoped
    @Scope(name = mainScope)
    fun provideTodoDao(database: NepAppDatabase): TodoDao {
        return database.todoDao()
    }

    @Factory
    @Scoped
    @Scope(SomeOtherScope::class)
    fun provideTodoDaoOther(database: NepAppDatabase): TodoDao {
        return database.todoDao()
    }
}