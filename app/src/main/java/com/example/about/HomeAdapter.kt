package com.example.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(
    var subjectHeading: Array<String>,
    var noOfSubjectHeading: Array<String>,
    var context: HomeFragment
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
        lateinit var itemListner: OnItemClickListner
        interface OnItemClickListner{
            fun onItemClickListener(position:Int)
        }
    fun setItemClickListener(listner: OnItemClickListner){
        itemListner = listner
    }
    class ViewHolder(itemView: View,itemListner: OnItemClickListner) : RecyclerView.ViewHolder(itemView) {
        val noOfSubjectHeadingView1 = itemView.findViewById<TextView>(R.id.noOfSubjectHeading1)
        val subjectHeadingView1 = itemView.findViewById<TextView>(R.id.subjectHeading1)
        val noOfSubjectHeadingView2 = itemView.findViewById<TextView>(R.id.noOfSubjectHeading2)
        val subjectHeadingView2 = itemView.findViewById<TextView>(R.id.subjectHeading2)
        val card1 = itemView.findViewById<CardView>(R.id.oneSubject)
        init {
                 card1.setOnClickListener{
                    itemListner.onItemClickListener(position = 0)
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView =
            LayoutInflater.from(parent.context).inflate(R.layout.home_items, parent, false)
        return ViewHolder(cardView,itemListner)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) {
            holder.noOfSubjectHeadingView1.text = noOfSubjectHeading[0]
            holder.subjectHeadingView1.text = subjectHeading[0]
            holder.noOfSubjectHeadingView2.text = noOfSubjectHeading[1]
            holder.subjectHeadingView2.text = subjectHeading[1]
        } else if (position == 1) {
            holder.noOfSubjectHeadingView1.text = noOfSubjectHeading[2]
            holder.subjectHeadingView1.text = subjectHeading[2]
            holder.noOfSubjectHeadingView2.text = noOfSubjectHeading[3]
            holder.subjectHeadingView2.text = subjectHeading[3]
        } else if (position == 2) {
            holder.noOfSubjectHeadingView1.text = noOfSubjectHeading[4]
            holder.subjectHeadingView1.text = subjectHeading[4]
            holder.noOfSubjectHeadingView2.text = noOfSubjectHeading[5]
            holder.subjectHeadingView2.text = subjectHeading[5]
        } else if (position == 3) {
            holder.noOfSubjectHeadingView1.text = noOfSubjectHeading[6]
            holder.subjectHeadingView1.text = subjectHeading[6]
            holder.noOfSubjectHeadingView2.text = noOfSubjectHeading[7]
            holder.subjectHeadingView2.text = subjectHeading[7]
        }
    }
}