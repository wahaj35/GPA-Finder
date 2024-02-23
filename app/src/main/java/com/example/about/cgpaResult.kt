package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.about.databinding.FragmentCgpaResultBinding

class CGPAResult : Fragment() {
    lateinit var binding: FragmentCgpaResultBinding
   private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cgpa_result, container, false)
        binding.apply {
            val semesterViews = arrayOf(
                semester1Text,
                semester2Text,
                semester3Text,
                semester4Text,
                semester5Text,
                semester6Text,
                semester7Text,
                semester8Text,
                semester9Text,
                semester10Text
            )
            val gpaViews = arrayOf(GPA1, GPA2, GPA3, GPA4, GPA5, GPA6, GPA7, GPA8, GPA9, GPA10)
            val creditsViews = arrayOf(
                credit1,
                credit2,
                credit3,
                credit4,
                credit5,
                credit6,
                credit7,
                credit8,
                credit9,
                credit10
            )
            for (i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()) {
                if (i == 0) {
                    cgpaVALUE.text = sharedViewModel.finalCGPA.value
                    creditVALUE.text = sharedViewModel.totalCreditHoursSemester.value
                }
                semesterViews[i].visibility = View.VISIBLE
                gpaViews[i].visibility = View.VISIBLE
                creditsViews[i].visibility = View.VISIBLE
                gpaViews[i].text = sharedViewModel.semesterGPA[i]
                creditsViews[i].text = sharedViewModel.totalCreditHoursSemesterList[i]
            }

            return root
        }

    }

}