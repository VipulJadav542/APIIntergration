package com.rk.apiintegration.Volly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rk.apiintegration.R

class MainActivity : AppCompatActivity() {

    val url = "https://api.github.com/users"
    var userInfoItemList = mutableListOf<userInfoItem>()
    var userInfo = userInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener { response ->
                val gson = Gson()
                val listType = object : TypeToken<List<userInfoItem>>() {}.type
                userInfoItemList = gson.fromJson(response, listType)

                userInfoItemList.forEach {
                    userInfo.add(it)

                }

                val adapter = MyRecyclerView(this, userInfo)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            },
            Response.ErrorListener { error ->
                // Your error handling code
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }
        )

// Set a longer timeout duration (in milliseconds)
        stringRequest.setRetryPolicy(
            DefaultRetryPolicy(
                10000,  // Timeout in milliseconds
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            )
        )

        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)
    }
}
