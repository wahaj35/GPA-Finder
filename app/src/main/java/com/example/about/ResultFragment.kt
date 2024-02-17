package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.about.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding
    val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        binding.apply {
            val subjectsView = arrayOf(subject1Text,subject2Text,subject3Text,subject4Text,subject5Text,subject6Text,subject7Text,subject8Text,subject9Text,subject10Text)
            val marksView = arrayOf(marks1,marks2,marks3,marks4,marks5,marks6,marks7,marks8,marks9,marks10)
            val gradeView = arrayOf(grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10)

            for (i in 0 until  sharedViewModel.noOf_subjects.value.toString().toInt()){
                        if(i == 0) {
                            gpaVALUE.text = sharedViewModel.finalGPA.value
                            creditVALUE.text = sharedViewModel.creditsEarned.value
                        }
                        subjectsView[i].visibility = View.VISIBLE
                        marksView[i].visibility = View.VISIBLE
                        gradeView[i].visibility = View.VISIBLE
                        marksView[i].text = sharedViewModel.studentMarks[i]
                        gradeView[i].text = sharedViewModel.courseGrades[i]
                    }

            return binding.root
        }
    }

}