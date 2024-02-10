package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MarksAdapter(var marks: Array<String>,var context:ReportFragment): RecyclerView.Adapter<MarksAdapter.ViewHolder>(){
    class ViewHolder (view: View):RecyclerView.ViewHolder(view){
          val marksView = view.findViewById<TextView>(R.id.marksText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.marks_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.marksView.text = marks[position]
    }
}