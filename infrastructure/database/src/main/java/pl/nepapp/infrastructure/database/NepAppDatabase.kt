package pl.nepapp.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.nepapp.data.todo.local.TodoDao
import pl.nepapp.data.todo.local.TodoEntity

@Database(entities = [TodoEntity::class], version = 3)
abstract class NepAppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}