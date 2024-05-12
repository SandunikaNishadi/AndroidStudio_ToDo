package com.example.managmentapp
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Managment")
class Entity (
    @PrimaryKey(autoGenerate =true)
    var id:Int,
    var title :String,
    var priority:String
)

