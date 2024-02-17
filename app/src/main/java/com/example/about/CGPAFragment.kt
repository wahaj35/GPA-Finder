package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.about.databinding.FragmentCgpaBinding

class CGPAFragment : Fragment() {
     lateinit var binding : FragmentCgpaBinding
     lateinit var recyclerView: RecyclerView
      val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cgpa,container,false)
        val noOfSemesters = arrayOf("2","3","4","5","6","7","8","9","10")
        recyclerView = binding.cardRecyclerView
        (recyclerView.layoutManager as GridLayoutManager).spanCount = 2
        val adapter = cgpaAdapter(noOfSemesters)
        recyclerView.adapter = adapter
        adapter.itemClickListener(object:cgpaAdapter.OnItemClickListener{
            override fun itemClickListener(position: Int,itemView: View) {
                sharedViewModel.noOfSemester.value = noOfSemesters[position]
                val cardView = itemView.findViewById<CardView>(R.id.cardView)
                cardView.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                view?.findNavController()?.navigate(R.id.action_CGPAFragment_to_cgpaDataInput)
            }
        })

        return binding.root
    }

}