package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.about.databinding.FragmentReport2Binding

class ReportFragment : Fragment() {
    private lateinit var binding: FragmentReport2Binding
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_report2,container, false)
        recyclerView = binding.coursesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val courses = arrayOf("Object Oriented Programming" ,"Data Structures", "Computer Networks", "English", "Discrete Structures" ,"English", "Math","Linear Algebra")
        val adapter = CoursesAdapter(courses,this)
        recyclerView.adapter = adapter
        return binding.root
    }



}