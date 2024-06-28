package com.rk.apiintegration.Volly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rk.apiintegration.R

class MyRecyclerView(val context: Context, private val userInfo: userInfo): RecyclerView.Adapter<MyRecyclerView.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val image: ImageView =itemView.findViewById(R.id.imageView)
        val title: TextView =itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.single_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  userInfo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(userInfo[position].avatar_url).into(holder.image)
        holder.title.text = userInfo[position].login
    }

}