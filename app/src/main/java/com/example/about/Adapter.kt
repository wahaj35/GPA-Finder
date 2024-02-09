package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(var courses:Array<String>,val context:ReportFragment):RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var coursesTextView = view.findViewById<TextView>(R.id.course1CardText)
        val cardView = view.findViewById<CardView>(R.id.course1Card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.courses_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return 8
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coursesTextView.text = courses[position]
    }
}