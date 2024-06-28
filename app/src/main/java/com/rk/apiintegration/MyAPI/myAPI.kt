package com.rk.apiintegration.Volly

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rk.apiintegration.MyAPI.MRecyclerView
import com.rk.apiintegration.MyAPI.Mydata1
import com.rk.apiintegration.MyAPI.Mydata1Item
import com.rk.apiintegration.R

class myAPI : AppCompatActivity() {

    val url = "http://172.16.1.210:3000/destination"

    var myAPIData = mutableListOf<Mydata1Item>()
    var mydata = Mydata1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_api)

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val stringRequest = StringRequest(url, Response.Listener { response ->
            val gson = Gson()
            val listType = object : TypeToken<List<Mydata1Item>>() {}.type
            myAPIData = gson.fromJson(response, listType)

            myAPIData.forEach {
                mydata.add(it)
//                Log.d("new", it.url)
            }

            val adapter= MRecyclerView(this,mydata)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

//            Toast.makeText(this, userInfo.toString(), Toast.LENGTH_LONG).show()
        }, Response.ErrorListener {
//            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            Log.d("errro", it.toString())
        })


        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)
    }
}
