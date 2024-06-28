package com.rk.apiintegration.NewsAPI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rk.apiintegration.MyRetrofit.DataClass
import com.rk.apiintegration.MyRetrofit.DataClassItem
import com.rk.apiintegration.R
import com.rk.apiintegration.databinding.SinglerowdataBinding

class RetrofirAdapter(val context: Context, private val articles: List<DataClassItem>, private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RetrofirAdapter.ArticleViewHolder>() {

    interface OnItemClickListener
    {
        fun OnShowData(id:String, title:String,body:String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        var binding = SinglerowdataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.newsImage.text= "page "+article.id.toString()
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.body
        holder.binding.cardView.setOnClickListener {
            itemClickListener.OnShowData(article.id.toString(), article.title, article.body)
        }
    }

    class ArticleViewHolder(val binding: SinglerowdataBinding):RecyclerView.ViewHolder(binding.root) {
        val newsImage=binding.id
        val newsTitle=binding.title
        val newsDescription=binding.body
    }
}