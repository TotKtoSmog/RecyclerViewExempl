package com.example.recyclerviewexempl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexempl.databinding.ItemBinding

class MyAdapter (val list: List<Person>) : RecyclerView.Adapter<MyAdapter.MyView>() {
    class MyView(viewItemBinding: ItemBinding) : RecyclerView.ViewHolder(viewItemBinding.root){
        val fname: TextView = viewItemBinding.fname
        val lname: TextView = viewItemBinding.lname
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return  MyView(itemView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.fname.text = list[position].firstname
        holder.lname.text = list[position].lastname
    }
}