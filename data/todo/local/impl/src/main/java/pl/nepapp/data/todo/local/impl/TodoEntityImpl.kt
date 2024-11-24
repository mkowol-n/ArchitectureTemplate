package pl.nepapp.data.todo.local.impl

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.nepapp.data.todo.local.TodoEntity

@Entity(tableName = "Todo")
data class TodoEntityImpl(
    @PrimaryKey override val id: String,
    @ColumnInfo("title") override val title: String,
    @ColumnInfo("description") override val description: String,
) : TodoEntity