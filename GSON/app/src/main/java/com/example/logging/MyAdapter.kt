package com.example.logging

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

class MyAdapter(private val itemList: List<Drawable>, private val linkList: List<String>)
                : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var topic : ImageView
        init {
            itemView.setOnClickListener(this)
            topic = itemView.findViewById<View>(R.id.imageView) as ImageView
        }

        override fun onClick(view: View) {
            Toast.makeText(view.context, "copied", Toast.LENGTH_SHORT).show()
            Timber.i(linkList[adapterPosition])
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.rview_item, null)
        return MyViewHolder(layoutView)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.topic.setImageDrawable(itemList[position])
    }
}