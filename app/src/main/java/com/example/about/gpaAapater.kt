package com.example.about

import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class gpaAapater(
    private val subjectsNo: List<String>, private val subjects: List<String>
) : RecyclerView.Adapter<gpaAapater.ViewHolder>() {
    private lateinit var gestureDetector: GestureDetector
    lateinit var clickListener: SetOnItemClickListener

    interface SetOnItemClickListener {
        fun itemClickListener(position: Int, view: View)
    }

    fun setItemClickListener(listener: SetOnItemClickListener) {
        clickListener = listener
    }

    class ViewHolder(itemView: View, clickListener: SetOnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val noOfSubjects = itemView.findViewById<TextView>(R.id.noOfSubjectsText)
        val subjects = itemView.findViewById<TextView>(R.id.subjectsText)

        init {
            itemView.setOnClickListener {
                clickListener.itemClickListener(adapterPosition, itemView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gpa_items, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int = subjectsNo.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noOfSubjects.text = subjectsNo[position]
        when (position) {
            0 -> holder.subjects.text = subjects[0]
            else -> holder.subjects.text = subjects[1]
        }
    }


}
