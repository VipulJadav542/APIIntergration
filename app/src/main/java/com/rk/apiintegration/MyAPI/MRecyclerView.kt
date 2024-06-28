package com.rk.apiintegration.MyAPI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rk.apiintegration.R

class MRecyclerView(val context: Context, val mydata: Mydata1): RecyclerView.Adapter<MRecyclerView.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val image=itemView.findViewById<ImageView>(R.id.imageView)
        val title=itemView.findViewById<TextView>(R.id.title)
        val description=itemView.findViewById<TextView>(R.id.description)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.single_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  mydata.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(mydata.get(position).url).into(holder.image)
        holder.title.text = mydata.get(position).city
        holder.description.text = mydata.get(position).description
    }

}