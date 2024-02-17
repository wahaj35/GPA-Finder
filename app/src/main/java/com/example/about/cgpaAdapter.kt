package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class cgpaAdapter(private val noOfSemesters:Array<String>):RecyclerView.Adapter<cgpaAdapter.ViewHolder>() {
    lateinit var clickListener: OnItemClickListener
    interface OnItemClickListener{
        fun itemClickListener(position: Int,itemView: View)
    }
    fun itemClickListener(listener: OnItemClickListener){
        clickListener = listener
    }

    class ViewHolder(itemView: View,clickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView) {
        val semesterNo = itemView.findViewById<TextView>(R.id.noOfSemesters)
        init {
            itemView.setOnClickListener {
                clickListener.itemClickListener(adapterPosition,itemView)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cgpa_items,parent,false)
        return ViewHolder(view,clickListener)
    }

    override fun getItemCount(): Int = noOfSemesters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.semesterNo.text = noOfSemesters[position]
    }
}