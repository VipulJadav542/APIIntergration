package com.rk.apiintegration.MyRetrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.rk.apiintegration.NewsAPI.RetrofirAdapter
import com.rk.apiintegration.databinding.ActivityMyRetrofitBinding
import com.rk.apiintegration.databinding.SinglerowdataBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MyRetrofit : AppCompatActivity(),RetrofirAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMyRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAllData()
    }

    private fun getAllData() {
        val AllData = RetrofitServices.interfaces.getAllData()
        AllData.enqueue(object : Callback<DataClass> {
            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                val data = response.body()
                if (data != null) {
                    val adapter= RetrofirAdapter(this@MyRetrofit,data,this@MyRetrofit)
                    binding.recyclerView3.adapter=adapter
                    binding.recyclerView3.layoutManager=LinearLayoutManager(this@MyRetrofit)
                    Log.d("response", data.toString())
                }
            }
            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                Log.d("error", t.toString())
            }
        })
    }

    override fun OnShowData(id: String, title: String, body: String) {
        val dialogBinding = SinglerowdataBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this).setView(dialogBinding.root)
            dialogBinding.id.text=id
            dialogBinding.title.text=title
            dialogBinding.body.text=body
        dialog.show()
    }
}