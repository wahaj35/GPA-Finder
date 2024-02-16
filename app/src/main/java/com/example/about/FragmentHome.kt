package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.about.databinding.FragmentHome2Binding

class FragmentHome : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentHome2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home2, container, false)
        recyclerView = binding.homeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = HomeAdapter()
        recyclerView.adapter = adapter
           adapter.itemClickListener(object :HomeAdapter.OnItemClickListener{
               override fun itemClickListener(position: Int,view: View) {
                   val cardView = view.findViewById<CardView>(R.id.cardView)
                   cardView.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                   when(position){
                       0 -> view?.findNavController()?.navigate(R.id.action_fragmentHome_to_GPAFragment)
                       1 -> view?.findNavController()?.navigate(R.id.action_fragmentHome_to_CGPAFragment)
                   }
               }
           })
        return binding.root
    }
}