package com.example.managmentapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAO {
    @Insert
    fun insertTask(entity: com.example.managmentapp.Entity): Long // Changed return type to Long

    @Update
    fun updateTask(entity: Entity): Int // Changed return type to Int

    @Delete
    fun deleteTask(entity: Entity): Int // Changed return type to Int

    @Query("DELETE FROM Managment")
    fun deleteAll(): Int // Changed return type to Int

    @Query("SELECT * FROM Managment")
    fun getTask(): List<CardInfo>
}
