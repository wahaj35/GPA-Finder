package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeItemsAdapter(private val subjects:List<String>):RecyclerView.Adapter<HomeItemsAdapter.ViewHolder>() {
    lateinit var clickListener: SetOnItemClickListener
    interface SetOnItemClickListener{
        fun itemClickListener(position: Int, view: View)
    }
    fun setItemClickListener(listener: SetOnItemClickListener){
        clickListener = listener
    }
    class ViewHolder(itemView:View,clickListener: SetOnItemClickListener):RecyclerView.ViewHolder(itemView) {
               val noOfSubjects  = itemView.findViewById<TextView>(R.id.noOfSubjectsText)
        init {
            itemView.setOnClickListener{
                clickListener.itemClickListener(adapterPosition,itemView)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ViewHolder(view,clickListener)
    }

    override fun getItemCount(): Int = subjects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noOfSubjects.text = subjects[position]
    }

}