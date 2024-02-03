package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.about.databinding.FragmentDataInputBinding
import com.example.about.databinding.FragmentReportBinding


class Report : Fragment() {
    lateinit var binding: FragmentReportBinding
    val sharedViewModel:SharedViewModel by activityViewModels()
    var data = Data()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
//        binding.data = data
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_report, container,false)

//        sharedViewModel.studentMarks.observe(viewLifecycleOwner) { studentMarks ->
//            binding.EnterNameEditText.setText(studentMarks)
//        }
        binding.GenerateButton.setOnClickListener{
            data.name = binding.EnterNameEditText.text.toString()
            data.registration = binding.EnterRegNoEditText.text.toString()
            data.department = binding.EnterDepartmentEditText.text.toString()
            data.semester = binding.EnterSemesterEditText.text.toString()
            binding.StudentName.text = data.name
            binding.RegistrationNo.text = data.registration
            binding.semesterNo.text = data.semester
            binding.DepartmentName.text = data.department

            sharedViewModel.creditsEarned.observe(viewLifecycleOwner) {creditsEarned -> binding.creditsEarned.setText(creditsEarned) }
            sharedViewModel.finalGPA.observe(viewLifecycleOwner) {finalGPA -> binding.gpaValue.setText(finalGPA)}

        }


        return binding.root
    }

}