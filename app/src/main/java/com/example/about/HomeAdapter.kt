package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter():RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    lateinit var clickListener: OnItemClickListener
    interface OnItemClickListener{
        fun itemClickListener(position: Int,view:View)
    }
    fun itemClickListener(listener: OnItemClickListener){
        clickListener = listener
    }
    class ViewHolder(itemView: View,clickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){
        val gpaAndCGPAText = itemView.findViewById<TextView>(R.id.calculateGPAText)
        init {
            itemView.setOnClickListener {
                clickListener.itemClickListener(adapterPosition,itemView)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_items,parent,false)
        return ViewHolder(view,clickListener)
    }

    override fun getItemCount(): Int  = 2
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       when(position){
           0 -> holder.gpaAndCGPAText.text = "GPA"
           1 -> holder.gpaAndCGPAText.text = "CGPA"
       }
    }
}