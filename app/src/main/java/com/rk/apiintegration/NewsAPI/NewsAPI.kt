package com.rk.apiintegration.NewsAPI

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rk.apiintegration.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class NewsAPI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_api)
        getNews()
        GlobalScope.launch {
            val API=NewsServices.newsInstance.getAll()
            if (API != null)
            {
                Log.d("result", API.body().toString())
            }
        }
    }

    private fun getNews() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        val news = NewsServices.newsInstance.getNewsHeadlines("techcrunch")
        val everything = NewsServices.newsInstance.getEverything("wsj.com")

        everything.enqueue(object : retrofit2.Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val everything = response.body()
                if (everything != null) {
                    Log.d("response", response.body().toString())
                    val adapter=NewsAdapter(this@NewsAPI,everything.articles)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this@NewsAPI)
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(this@NewsAPI, "Error", Toast.LENGTH_SHORT).show()
            }
        })
//        news.enqueue(object : retrofit2.Callback<News> {
//            override fun onResponse(call: Call<News>, response: Response<News>) {
//                val news = response.body()
//                if (news != null) {
//                    Log.d("response", response.body().toString())
//                    val adapter = NewsAdapter(this@NewsAPI, news.articles)
//                    recyclerView.adapter = adapter
//                    recyclerView.layoutManager = LinearLayoutManager(this@NewsAPI)
//                }
//            }
//            override fun onFailure(call: Call<News>, t: Throwable) {
//                Toast.makeText(this@NewsAPI, "Error", Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }
}