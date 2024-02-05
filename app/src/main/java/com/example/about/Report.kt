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

        view()

//        sharedViewModel.studentMarks.observe(viewLifecycleOwner) { studentMarks ->
//            binding.EnterNameEditText.setText(studentMarks)
//

        return binding.root
    }
    private fun view() {
        binding.apply {
        var noOfSubjects = sharedViewModel.noOf_subjects.value

            val marksLayout = arrayOf(
                Course1Marks,
                Course2Marks,
                Course3Marks,
                Course4Marks,
                Course5Marks,
                Course6Marks,
                Course7Marks

            )
            val coursesLayout  = arrayOf(
                Course1,
                Course2,
                Course3,
                Course4,
                Course5,
                Course6,
                Course7

            )

            val gradeLayout  = arrayOf(
                Course1Grade,
                Course2Grade,
                Course3Grade,
                Course4Grade,
                Course5Grade,
                Course6Grade,
                Course7Grade
            )

            var grade = Array(7){""}
        when (noOfSubjects) {
            "1" -> {
                for (i in 0 until 1) {
                    if(sharedViewModel.creditHours[i] == "4"){
                        grade[i] = CH4(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "3"){
                        grade[i] = CH3(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "2"){
                        grade[i] = CH2(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "1"){
                        grade[i] = CH1(sharedViewModel.studentMarks[i])
                    }
                    coursesLayout[i].text = sharedViewModel.subjectsNames[i]
                    gradeLayout[i].text = grade[i]
                    marksLayout[i].text = sharedViewModel.studentMarks[i]
                    coursesLayout[i].visibility = View.VISIBLE
                    marksLayout[i].visibility = View.VISIBLE
                    gradeLayout[i].visibility = View.VISIBLE
                }
                gpaValue.text = sharedViewModel.finalGPA.value
                creditsEarnedValue.text = sharedViewModel.creditsEarned.value
            }
            "2" -> {
                for (i in 0 until 2) {
                    if(sharedViewModel.creditHours[i] == "4"){
                        grade[i] = CH4(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "3"){
                        grade[i] = CH3(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "2"){
                        grade[i] = CH2(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "1"){
                        grade[i] = CH1(sharedViewModel.studentMarks[i])
                    }
                    coursesLayout[i].text = sharedViewModel.subjectsNames[i]
                    gradeLayout[i].text = grade[i]
                    marksLayout[i].text = sharedViewModel.studentMarks[i]
                    coursesLayout[i].visibility = View.VISIBLE
                    marksLayout[i].visibility = View.VISIBLE
                    gradeLayout[i].visibility = View.VISIBLE
                }
                gpaValue.text = sharedViewModel.finalGPA.value
                creditsEarnedValue.text = sharedViewModel.creditsEarned.value
            }
            "3" -> {
                for (i in 0 until 3) {
                    if(sharedViewModel.creditHours[i] == "4"){
                        grade[i] = CH4(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "3"){
                        grade[i] = CH3(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "2"){
                        grade[i] = CH2(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "1"){
                        grade[i] = CH1(sharedViewModel.studentMarks[i])
                    }
                    coursesLayout[i].text = sharedViewModel.subjectsNames[i]
                    gradeLayout[i].text = grade[i]
                    marksLayout[i].text = sharedViewModel.studentMarks[i]
                    coursesLayout[i].visibility = View.VISIBLE
                    marksLayout[i].visibility = View.VISIBLE
                    gradeLayout[i].visibility = View.VISIBLE
                }
                gpaValue.text = sharedViewModel.finalGPA.value
                creditsEarnedValue.text = sharedViewModel.creditsEarned.value
            }
            "4" -> {
                for (i in 0 until 4) {
                    if(sharedViewModel.creditHours[i] == "4"){
                        grade[i] = CH4(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "3"){
                        grade[i] = CH3(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "2"){
                        grade[i] = CH2(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "1"){
                        grade[i] = CH1(sharedViewModel.studentMarks[i])
                    }
                    coursesLayout[i].text = sharedViewModel.subjectsNames[i]
                    gradeLayout[i].text = grade[i]
                    marksLayout[i].text = sharedViewModel.studentMarks[i]
                    coursesLayout[i].visibility = View.VISIBLE
                    marksLayout[i].visibility = View.VISIBLE
                    gradeLayout[i].visibility = View.VISIBLE
                }
                gpaValue.text = sharedViewModel.finalGPA.value
                creditsEarnedValue.text = sharedViewModel.creditsEarned.value
            }
            "5" -> {
                for (i in 0 until 5) {
                    if(sharedViewModel.creditHours[i] == "4"){
                        grade[i] = CH4(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "3"){
                        grade[i] = CH3(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "2"){
                        grade[i] = CH2(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "1"){
                        grade[i] = CH1(sharedViewModel.studentMarks[i])
                    }
                    coursesLayout[i].text = sharedViewModel.subjectsNames[i]
                    gradeLayout[i].text = grade[i]
                    marksLayout[i].text = sharedViewModel.studentMarks[i]
                    coursesLayout[i].visibility = View.VISIBLE
                    marksLayout[i].visibility = View.VISIBLE
                    gradeLayout[i].visibility = View.VISIBLE
                }
                gpaValue.text = sharedViewModel.finalGPA.value
                creditsEarnedValue.text = sharedViewModel.creditsEarned.value
            }
            "6" -> {
                for (i in 0 until 6) {
                    if(sharedViewModel.creditHours[i] == "4"){
                        grade[i] = CH4(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "3"){
                        grade[i] = CH3(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "2"){
                        grade[i] = CH2(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "1"){
                        grade[i] = CH1(sharedViewModel.studentMarks[i])
                    }
                    coursesLayout[i].text = sharedViewModel.subjectsNames[i]
                    gradeLayout[i].text = grade[i]
                    marksLayout[i].text = sharedViewModel.studentMarks[i]
                    coursesLayout[i].visibility = View.VISIBLE
                    marksLayout[i].visibility = View.VISIBLE
                    gradeLayout[i].visibility = View.VISIBLE
                }
                gpaValue.text = sharedViewModel.finalGPA.value
                creditsEarnedValue.text = sharedViewModel.creditsEarned.value
            }
            "7" -> {
                for (i in 0 until 7) {
                    if(sharedViewModel.creditHours[i] == "4"){
                        grade[i] = CH4(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "3"){
                        grade[i] = CH3(sharedViewModel.studentMarks[i])
                    }  else if(sharedViewModel.creditHours[i] == "2"){
                        grade[i] = CH2(sharedViewModel.studentMarks[i])
                    } else if(sharedViewModel.creditHours[i] == "1"){
                        grade[i] = CH1(sharedViewModel.studentMarks[i])
                    }
                    coursesLayout[i].text = sharedViewModel.subjectsNames[i]
                    gradeLayout[i].text = grade[i]
                    marksLayout[i].text = sharedViewModel.studentMarks[i]
                    coursesLayout[i].visibility = View.VISIBLE
                    marksLayout[i].visibility = View.VISIBLE
                    gradeLayout[i].visibility = View.VISIBLE
                }
                gpaValue.text = sharedViewModel.finalGPA.value
                creditsEarnedValue.text = sharedViewModel.creditsEarned.value
            }

        }
    }
    }
    fun CH4(marks:String): String{
        if(marks.toInt() in 64 ..80) return "A"
            else if(marks.toInt() in 52 .. 63) return "B"
            else if(marks.toInt() in 40 .. 51) return "C"
            else if(marks.toInt() in 32 .. 39) return "D"
            else return "F"
    }
    fun CH3(marks: String): String {
        if(marks.toInt() in 48..60) return "A"
        else if(marks.toInt() in 39..47) return "B"
        else if(marks.toInt() in 30..38) return "C"
        else if(marks.toInt() in 24..29) return "D"
        else return "F"
    }

    fun CH2(marks: String): String {
        if(marks.toInt() in 32..40) return "A"
        else if(marks.toInt() in 26..31) return "B"
        else if(marks.toInt() in 20..25) return "C"
        else if(marks.toInt() in 16..19) return "D"
        else return "F"
    }
    fun CH1(marks: String): String {
        if(marks.toInt() in 16..20) return "A"
        else if(marks.toInt() in 13..15) return "B"
        else if(marks.toInt() in 10..12) return "C"
        else if(marks.toInt() in 8..9) return "D"
        else return "F"
    }

}