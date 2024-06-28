package com.rk.apiintegration.Retrofit

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.rk.apiintegration.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Retrofit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val QuoteApi=RetrofitBuilder.getInstance().create(myInterface::class.java)

        GlobalScope.launch {
            val result=QuoteApi.getQuotes()
            if(result != null) {
                Log.d("result", result.body().toString())
//                Toast.makeText(this@Retrofit,"data fetch successfully", Toast.LENGTH_LONG).show()
            }
        }
    }
}