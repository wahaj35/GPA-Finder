package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(var courseTitle: Array<String>,var context:ReportFragment): RecyclerView.Adapter<CoursesAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
             val course = view.findViewById<TextView>(R.id.coursesText)
             val courseView = view.findViewById<ConstraintLayout>(R.id.courseConstaintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.courses_item,parent,false)
        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return 7
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.course.text = courseTitle[position]
    }
}