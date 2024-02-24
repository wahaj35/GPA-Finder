package com.example.about
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
  private  lateinit var clickListener: OnItemClickListener

    interface OnItemClickListener{
        fun itemClickListener(position: Int,view:View)
        val mutex:Mutex
    }
    fun itemClickListener(listener: OnItemClickListener){
     clickListener = listener
    }
    @OptIn(DelicateCoroutinesApi::class)
    class ViewHolder(itemView: View, clickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){
        val gpaAndCGPAText :TextView= itemView.findViewById(R.id.calculateGPAText)
        init {
            itemView.setOnClickListener {
                itemView.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
                    clickListener.mutex.withLock { clickListener.itemClickListener(adapterPosition,itemView) }
                }

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
           0 -> holder.gpaAndCGPAText.setText(R.string.GPAText)
           1 -> holder.gpaAndCGPAText.setText(R.string.CGPAText)
       }
    }
}