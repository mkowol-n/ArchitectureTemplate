package pl.nepapp.data.todo.local.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.nepapp.data.todo.local.TodoDao
import pl.nepapp.data.todo.local.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}