package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class cgpaAdapter(private val noOfSemesters:Array<String>):RecyclerView.Adapter<cgpaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val semesterNo = itemView.findViewById<TextView>(R.id.noOfSemesters)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cgpa_items,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = noOfSemesters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.semesterNo.text = noOfSemesters[position]
    }
}