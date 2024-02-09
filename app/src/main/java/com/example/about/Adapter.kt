package com.example.about

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.about.databinding.FragmentReport2Binding

class Adapter(var data:Array<String>,val context:Fragment):RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var subjectTextView = view.findViewById<TextView>(R.id.courseText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vew,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return 2
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        holder.subjectTextView.text = data
    }
}