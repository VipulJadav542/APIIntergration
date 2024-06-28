package com.rk.apiintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rk.apiintegration.MyRetrofit.MyRetrofit
import com.rk.apiintegration.NewsAPI.NewsAPI
import com.rk.apiintegration.Retrofit.Retrofit
import com.rk.apiintegration.RoomDb.InsertRoom
import com.rk.apiintegration.Volly.MainActivity
import com.rk.apiintegration.Volly.myAPI
import com.rk.apiintegration.databinding.ActivityHomeBinding
import com.rk.apiintegration.di.DependancyInjection

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this,myAPI::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this,MyRetrofit::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this,NewsAPI::class.java))
        }

        binding.button4.setOnClickListener {
            startActivity(Intent(this,Retrofit::class.java))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        binding.button6.setOnClickListener {
            startActivity(Intent(this,InsertRoom::class.java))
        }
        binding.DependencyInjection.setOnClickListener {
            startActivity(Intent(this,DependancyInjection::class.java))
        }
    }
}