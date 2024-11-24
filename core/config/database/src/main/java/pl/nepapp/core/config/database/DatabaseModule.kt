package pl.nepapp.core.config.database

import android.content.Context
import androidx.room.Room
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import pl.nepapp.data.todo.local.TodoDao

@Module
@ComponentScan("pl.nepapp.core.config.database")
class DatabaseModule {

    @Single
    fun provideDatabase(context: Context): NepAppDatabase {
        return Room.databaseBuilder(
            context = context,
            NepAppDatabase::class.java, "nepapp-database"
        ).build()
    }

    @Factory
    fun provideTodoDao(database: NepAppDatabase): TodoDao {
        return database.todoDao()
    }
}