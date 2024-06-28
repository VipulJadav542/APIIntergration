package com.rk.apiintegration.NewsAPI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rk.apiintegration.R

class NewsAdapter(val context: Context, val articles: List<Articles>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_row, parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description
        holder.itemView.setOnClickListener {
            Toast.makeText(context,"clicked article",Toast.LENGTH_SHORT).show()
        }
    }

    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val newsImage: ImageView =itemView.findViewById<ImageView>(R.id.imageView)
        val newsTitle=itemView.findViewById<TextView>(R.id.title)
        val newsDescription=itemView.findViewById<TextView>(R.id.description)
    }
}