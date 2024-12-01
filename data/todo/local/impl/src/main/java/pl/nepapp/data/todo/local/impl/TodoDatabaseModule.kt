package pl.nepapp.data.todo.local.impl

import android.content.Context
import androidx.room.Room
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import pl.nepapp.data.todo.local.TodoDao

@Module
@ComponentScan("pl.nepapp.data.todo.local.impl")
class TodoDatabaseModule {

    @Single
    fun provideDatabase(context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context = context,
            TodoDatabase::class.java, "todo-database"
        ).build()
    }

    @Single
    fun provideTodoDao(database: TodoDatabase): TodoDao {
        return database.todoDao()
    }
}