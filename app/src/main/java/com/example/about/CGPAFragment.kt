package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.about.databinding.FragmentCgpaBinding

class CGPAFragment : Fragment() {
     lateinit var binding : FragmentCgpaBinding
     lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cgpa,container,false)
        val noOfSemesters = arrayOf("2","3","4","5","6","7","8")
        recyclerView = binding.cardRecyclerView
        (recyclerView.layoutManager as GridLayoutManager).spanCount = 2
        val adapter = cgpaAdapter(noOfSemesters)
        recyclerView.adapter = adapter

        return binding.root
    }

}