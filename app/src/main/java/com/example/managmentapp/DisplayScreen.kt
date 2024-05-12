package com.example.managmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DisplayScreen : AppCompatActivity() {
    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_screen)

        database= Room.databaseBuilder(
            applicationContext,myDatabase::class.java, "Managmnent "
        ).build()
         GlobalScope.launch {
         DataObject.listdata =database.dao().getTask() as MutableList<CardInfo>
     }
        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this,MainActivity::class.java)
      startActivity(intent)
        },2000)
    }
}