package pl.nepapp.data.todo.local.impl

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nepapp.data.todo.local.TodoDao
import pl.nepapp.data.todo.local.TodoEntity

@Dao
interface TodoDaoImpl: TodoDao {
    @Query("SELECT * FROM todo")
    override suspend fun getAll(): List<TodoEntityImpl>

    @Query("SELECT * FROM todo")
    override fun getAllFlow(): Flow<List<TodoEntityImpl>>
}