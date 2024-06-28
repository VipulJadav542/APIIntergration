package com.rk.apiintegration.RoomDb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rk.apiintegration.R
import com.rk.apiintegration.databinding.ActivityInsetRoomBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InsertRoom : AppCompatActivity() {
    private lateinit var binding: ActivityInsetRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsetRoomBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.button6)
        button.setOnClickListener {

            val text1 = binding.editTextText.text.toString()
            val text2 = binding.editTextText2.text.toString()
            val text3 = binding.editTextNumberSigned.text.toString()

            if (text1.isNotEmpty() && text2.isNotEmpty() && text3.isNotEmpty()) {
                val age = text3.toIntOrNull() ?: 0
                val data = Entity(firstName = text1, lastName = text2, age = age)
                val database=AppDatabase.getDatabase(this)
                val Dao=database.userDao()
                CoroutineScope(Dispatchers.IO).launch {
                    Dao.insert(data)
                    runOnUiThread {
                        Toast.makeText(this@InsertRoom, "Insert success", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.button7).setOnClickListener {
            startActivity(Intent(this, RoomDb::class.java))
        }
    }
}
