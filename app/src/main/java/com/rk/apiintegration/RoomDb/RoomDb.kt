package com.rk.apiintegration.RoomDb

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.rk.apiintegration.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomDb : AppCompatActivity() {
    private lateinit var yourDao: Dao
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_room_db)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app-database").build()
        yourDao = db.userDao()
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView4)

        CoroutineScope(Dispatchers.IO).launch {
        val entities = yourDao.getAll()
            val adapter=AdapterRoom(this@RoomDb,entities)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@RoomDb)
        }
    }
}