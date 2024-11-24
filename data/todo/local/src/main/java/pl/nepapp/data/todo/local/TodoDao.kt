package pl.nepapp.data.todo.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    suspend fun getAll(): List<TodoEntity>

    @Query("SELECT * FROM todo")
    fun getAllFlow(): Flow<List<TodoEntity>>

    @Insert
    suspend fun insertAll(todos: List<TodoEntity>)
}