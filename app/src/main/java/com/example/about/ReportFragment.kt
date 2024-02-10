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
    private lateinit var coursesRecyclerView: RecyclerView
    private lateinit var marksRecyclerView: RecyclerView
    private lateinit var gradeRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_report2,container, false)
        val courses  = arrayOf("Object Oriented Programming", "Data Structures", "Computer Networks","Discrete Structures", "English", "Linear Algebra", "Digital Logic And Design")
        val marks = arrayOf("50", "80", "90","80", "50", "80", "90")
        val grade = arrayOf("A", "B", "D","E", "F", "A", "B")
        coursesRecyclerView = binding.coursesRecyclerView
        marksRecyclerView = binding.marksRecyclerView
        gradeRecyclerView = binding.gradeRecyclerView
        coursesRecyclerView.layoutManager = LinearLayoutManager(context)
        marksRecyclerView.layoutManager = LinearLayoutManager(context)
        gradeRecyclerView.layoutManager = LinearLayoutManager(context)
        coursesRecyclerView.adapter = CoursesAdapter(courses,this)
        marksRecyclerView.adapter = MarksAdapter(marks,this)
        gradeRecyclerView.adapter = GradeAdapter(grade,this)

        return binding.root
    }



}