package com.example.about

import android.annotation.SuppressLint
import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.about.databinding.FragmentDataInputBinding

class DataInput : Fragment() {
    private lateinit var noOfSubjects: String // The variable to store the no.of subjects entered by user
    private val gpa_text = GPA()
   private lateinit var GPA: String
   private lateinit var totalCreditsEarned: String
   private lateinit var subjectGrades: Array<String>
    lateinit var binding: FragmentDataInputBinding
    val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_input, container, false)
        // Binding all the data classes to the ActivityMainClass
        binding.gpaText = gpa_text
        // Setting up setOnClickListener on the buttons.
        binding.apply {
            // Setting up setOnClickLick method for the layout to view according to the user input
            enterButton.setOnClickListener { view() }
            // Setting up setOnClickLick method for the GPA Button
            checkGPAButton.setOnClickListener { chkGPA() }

//            checkReportButton.setOnClickListener{view:View ->
//                Navigation.findNavController(view).navigate(R.id.action_DataInput_to_reportFragment)
//            }
//            checkReportButton.setOnClickListener { view: View ->
//                sharedViewModel.noOf_subjects.value = noOfSubjects
////                sharedViewModel.creditsEarned.value = totalCreditsEarned
////                sharedViewModel.finalGPA.value = GPA
////                sharedViewModel.getGrades(subjectGrades)
//                when (noOfSubjects) {
//                    "1" -> {
//                        val isTrue = DataBetweenFragments()
//                        if (isTrue) {
//                            Navigation.findNavController(view)
//                                .navigate(R.id.action_DataInput_to_reportFragment)
//                        } else Toast.makeText(activity, "Enter Subjects Names", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    "2" -> {
//                        val isTrue = DataBetweenFragments()
//                        if (isTrue) {
//                            Navigation.findNavController(view)
//                                .navigate(R.id.action_DataInput_to_reportFragment)
//                        } else Toast.makeText(activity, "Enter Subjects Names", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    "3" -> {
//                        val isTrue = DataBetweenFragments()
//                        if (isTrue) {
//                            Navigation.findNavController(view)
//                                .navigate(R.id.action_DataInput_to_reportFragment)
//                        } else Toast.makeText(activity, "Enter Subjects Names", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    "4" -> {
//                        val isTrue = DataBetweenFragments()
//                        if (isTrue) {
//                            Navigation.findNavController(view)
//                                .navigate(R.id.action_DataInput_to_reportFragment)
//                        } else Toast.makeText(activity, "Enter Subjects Names", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    "5" -> {
//                        val isTrue = DataBetweenFragments()
//                        if (isTrue) {
//                            Navigation.findNavController(view)
//                                .navigate(R.id.action_DataInput_to_reportFragment)
//                        } else Toast.makeText(activity, "Enter Subjects Names", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    "6" -> {
//                        val isTrue = DataBetweenFragments()
//                        if (isTrue) {
//                            Navigation.findNavController(view)
//                                .navigate(R.id.action_DataInput_to_reportFragment)
//                        } else Toast.makeText(activity, "Enter Subjects Names", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    "7" -> {
//                        val isTrue = DataBetweenFragments()
//                        if (isTrue) {
//                            Navigation.findNavController(view)
//                                .navigate(R.id.action_DataInput_to_reportFragment)
//                        } else Toast.makeText(activity, "Enter Subjects Names", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    else -> {
//                        Toast.makeText(activity, "Invalid No.Of Subjects", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                }
//            }

        }

        return binding.root
    }


    fun DataBetweenFragments(): Boolean {
        binding.apply {
            val marks = arrayOf(
                Subject1Marks.text.toString(),
                Subject2Marks.text.toString(),
                Subject3Marks.text.toString(),
                Subject4Marks.text.toString(),
                Subject5Marks.text.toString(),
                Subject6Marks.text.toString(),
                Subject7Marks.text.toString()
            )
            val creditHours = arrayOf(
                creditHours1.text.toString(),
                creditHours2.text.toString(),
                creditHours3.text.toString(),
                creditHours4.text.toString(),
                creditHours5.text.toString(),
                creditHours6.text.toString(),
                creditHours7.text.toString()
            )
            val subjects = arrayOf(
                Subject1.text.toString(),
                Subject2.text.toString(),
                Subject3.text.toString(),
                Subject4.text.toString(),
                Subject5.text.toString(),
                Subject6.text.toString(),
                Subject7.text.toString()
            )

            when (noOfSubjects) {
                "1" -> {
                    return if (binding.Subject1.text.toString() != "") {
                        for (i in 0 until 1) {
                            sharedViewModel.setSubjects(arrayOf(subjects[i]))
                            sharedViewModel.setMarks(arrayOf(marks[i]))
                            sharedViewModel.setCreditHours(arrayOf(creditHours[i]))
                        }
                        true
                    } else false
                }

                "2" -> {
                    return if ((binding.Subject1.text.toString() != "") && (binding.Subject2.text.toString() != "")) {
                        sharedViewModel.setSubjects(arrayOf(subjects[0], subjects[1]))
                        sharedViewModel.setMarks(arrayOf(marks[0], marks[1]))
                        sharedViewModel.setCreditHours(arrayOf(creditHours[0], creditHours[1]))
                        true
                    } else false
                }

                "3" -> {
                    return if ((binding.Subject1.text.toString() != "") && (binding.Subject2.text.toString() != "") && (binding.Subject3.text.toString() != "")) {
                        sharedViewModel.setSubjects(arrayOf(subjects[0], subjects[1], subjects[2]))
                        sharedViewModel.setMarks(arrayOf(marks[0], marks[1], marks[2]))
                        sharedViewModel.setCreditHours(
                            arrayOf(
                                creditHours[0],
                                creditHours[1],
                                creditHours[2]
                            )
                        )
                        true
                    } else false
                }

                "4" -> {
                    return if ((binding.Subject1.text.toString() != "") && (binding.Subject2.text.toString() != "") && (binding.Subject3.text.toString() != "") && (binding.Subject4.text.toString() != "")) {
                        sharedViewModel.setSubjects(
                            arrayOf(
                                subjects[0],
                                subjects[1],
                                subjects[2],
                                subjects[3]
                            )
                        )
                        sharedViewModel.setMarks(arrayOf(marks[0], marks[1], marks[2], marks[3]))
                        sharedViewModel.setCreditHours(
                            arrayOf(
                                creditHours[0],
                                creditHours[1],
                                creditHours[2],
                                creditHours[3]
                            )
                        )
                        true
                    } else false
                }

                "5" -> {
                    return if ((binding.Subject1.text.toString() != "") && (binding.Subject2.text.toString() != "") && (binding.Subject3.text.toString() != "") && (binding.Subject4.text.toString() != "") && (binding.Subject5.text.toString() != "")) {
                        sharedViewModel.setSubjects(
                            arrayOf(
                                subjects[0],
                                subjects[1],
                                subjects[2],
                                subjects[3],
                                subjects[4]
                            )
                        )
                        sharedViewModel.setMarks(
                            arrayOf(
                                marks[0],
                                marks[1],
                                marks[2],
                                marks[3],
                                marks[4]
                            )
                        )
                        sharedViewModel.setCreditHours(
                            arrayOf(
                                creditHours[0],
                                creditHours[1],
                                creditHours[2],
                                creditHours[3],
                                creditHours[4]
                            )
                        )
                        true
                    } else false
                }

                "6" -> {
                    return if ((binding.Subject1.text.toString() != "") && (binding.Subject2.text.toString() != "") && (binding.Subject3.text.toString() != "") && (binding.Subject4.text.toString() != "") && (binding.Subject5.text.toString() != "") && (binding.Subject6.text.toString() != "")) {
                        sharedViewModel.setSubjects(
                            arrayOf(
                                subjects[0],
                                subjects[1],
                                subjects[2],
                                subjects[3],
                                subjects[4],
                                subjects[5]
                            )
                        )
                        sharedViewModel.setMarks(
                            arrayOf(
                                marks[0],
                                marks[1],
                                marks[2],
                                marks[3],
                                marks[4],
                                marks[5]
                            )
                        )
                        sharedViewModel.setCreditHours(
                            arrayOf(
                                creditHours[0],
                                creditHours[1],
                                creditHours[2],
                                creditHours[3],
                                creditHours[4],
                                creditHours[5]
                            )
                        )
                        true
                    } else false
                }

                "7" -> {
                    return if ((binding.Subject1.text.toString() != "") && (binding.Subject2.text.toString() != "") && (binding.Subject3.text.toString() != "") && (binding.Subject4.text.toString() != "") && (binding.Subject5.text.toString() != "") && (binding.Subject6.text.toString() != "") && (binding.Subject7.text.toString() != "")) {
                        sharedViewModel.setSubjects(
                            arrayOf(
                                subjects[0],
                                subjects[1],
                                subjects[2],
                                subjects[3],
                                subjects[4],
                                subjects[5],
                                subjects[6]
                            )
                        )
                        sharedViewModel.setMarks(
                            arrayOf(
                                marks[0],
                                marks[1],
                                marks[2],
                                marks[3],
                                marks[4],
                                marks[5],
                                marks[6]
                            )
                        )
                        sharedViewModel.setCreditHours(
                            arrayOf(
                                creditHours[0],
                                creditHours[1],
                                creditHours[2],
                                creditHours[3],
                                creditHours[4],
                                creditHours[5],
                                creditHours[6]
                            )
                        )
                        true
                    } else false
                }

                else -> return false

            }
        }
    }

    private fun view() {
        noOfSubjects = binding.noOfSubjectsInputBar.text.toString()
        val layouts = arrayOf(
            binding.layout1,
            binding.layout2,
            binding.layout3,
            binding.layout4,
            binding.layout5,
            binding.layout6,
            binding.layout7
        )

        val marks = arrayOf(
            binding.Subject1Marks,
            binding.Subject2Marks,
            binding.Subject3Marks,
            binding.Subject4Marks,
            binding.Subject5Marks,
            binding.Subject6Marks,
            binding.Subject7Marks
        )
        val credits = arrayOf(
            binding.creditHours1,
            binding.creditHours2,
            binding.creditHours3,
            binding.creditHours4,
            binding.creditHours5,
            binding.creditHours6,
            binding.creditHours7,

            )
        val subjects = arrayOf(
            binding.Subject1,
            binding.Subject2,
            binding.Subject3,
            binding.Subject4,
            binding.Subject5,
            binding.Subject6,
            binding.Subject7

        )

        when (noOfSubjects) {
            "1" -> {
                binding.scrollView2.visibility = View.VISIBLE
                for (i in 0 until 7) {
                    if (i == 0) layouts[i].visibility = View.VISIBLE
                    else layouts[i].visibility = View.GONE
                    marks[i].setText("")
                    credits[i].setText("")
                    subjects[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.VISIBLE
                binding.ButtonLayout.visibility = View.VISIBLE
                binding.GPALayout.visibility = View.GONE
            }

            "2" -> {
                binding.scrollView2.visibility = View.VISIBLE
                for (i in 0 until 7) {
                    if (i in 0..1) layouts[i].visibility = View.VISIBLE
                    else layouts[i].visibility = View.GONE
                    marks[i].setText("")
                    credits[i].setText("")
                    subjects[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.VISIBLE
                binding.ButtonLayout.visibility = View.VISIBLE
                binding.GPALayout.visibility = View.GONE
            }

            "3" -> {
                binding.scrollView2.visibility = View.VISIBLE
                for (i in 0 until 7) {
                    if (i in 0..2) layouts[i].visibility = View.VISIBLE
                    else layouts[i].visibility = View.GONE
                    marks[i].setText("")
                    credits[i].setText("")
                    subjects[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.VISIBLE
                binding.ButtonLayout.visibility = View.VISIBLE
                binding.GPALayout.visibility = View.GONE
            }

            "4" -> {
                binding.scrollView2.visibility = View.VISIBLE
                for (i in 0 until 7) {
                    if (i in 0..3) layouts[i].visibility = View.VISIBLE
                    else layouts[i].visibility = View.GONE
                    marks[i].setText("")
                    credits[i].setText("")
                    subjects[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.VISIBLE
                binding.ButtonLayout.visibility = View.VISIBLE
                binding.GPALayout.visibility = View.GONE
            }

            "5" -> {
                binding.scrollView2.visibility = View.VISIBLE
                for (i in 0 until 7) {
                    if (i in 0..4) layouts[i].visibility = View.VISIBLE
                    else layouts[i].visibility = View.GONE
                    marks[i].setText("")
                    credits[i].setText("")
                    subjects[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.VISIBLE
                binding.ButtonLayout.visibility = View.VISIBLE
                binding.GPALayout.visibility = View.GONE
            }

            "6" -> {
                binding.scrollView2.visibility = View.VISIBLE
                for (i in 0 until 7) {
                    if (i in 0..5) layouts[i].visibility = View.VISIBLE
                    else layouts[i].visibility = View.GONE
                    marks[i].setText("")
                    credits[i].setText("")
                    subjects[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.VISIBLE
                binding.ButtonLayout.visibility = View.VISIBLE
                binding.GPALayout.visibility = View.GONE
            }

            "7" -> {
                binding.scrollView2.visibility = View.VISIBLE
                for (i in 0 until 7) {
                    layouts[i].visibility = View.VISIBLE
                    marks[i].setText("")
                    credits[i].setText("")
                    subjects[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.VISIBLE
                binding.ButtonLayout.visibility = View.VISIBLE
                binding.GPALayout.visibility = View.GONE
            }

            else -> {
                for (i in 0 until 7) {
                    layouts[i].visibility = View.GONE
                    marks[i].setText("")
                    credits[i].setText("")
                }
                binding.noOfSubjectsInputBar.setText("")
                binding.subjectsAndMarksHeader.visibility = View.GONE
                binding.ButtonLayout.visibility = View.GONE
                binding.GPALayout.visibility = View.GONE
                Toast.makeText(activity, "Invalid No.Of Subjects", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //This function will be called when the chkGPA button will be entered to calculate the GPA according to the given Input.
    @SuppressLint("ResourceAsColor")
    private fun chkGPA() {
        binding.apply {
            // Assigning the EditText Credit Hours and Marks to the Properties of the Marks and Credit Hours Class
            val qp = Array(noOfSubjects.toInt()){""}
            val grades = Array(noOfSubjects.toInt()){""}
            subjectGrades = grades
            val marks = arrayOf(
                Subject1Marks.text.toString(),
                Subject2Marks.text.toString(),
                Subject3Marks.text.toString(),
                Subject4Marks.text.toString(),
                Subject5Marks.text.toString(),
                Subject6Marks.text.toString(),
                Subject7Marks.text.toString()
            )
            val creditHours = arrayOf(
                creditHours1.text.toString(),
                creditHours2.text.toString(),
                creditHours3.text.toString(),
                creditHours4.text.toString(),
                creditHours5.text.toString(),
                creditHours6.text.toString(),
                creditHours7.text.toString()

            )

            this.invalidateAll()
            when (noOfSubjects) {
                "7" -> {
                    if ((binding.Subject1Marks.text.toString() != "") &&
                        (binding.Subject2Marks.text.toString() != "") &&
                        (binding.Subject3Marks.text.toString() != "") &&
                        (binding.Subject4Marks.text.toString() != "") &&
                        (binding.Subject5Marks.text.toString() != "") &&
                        (binding.Subject6Marks.text.toString() != "") &&
                        (binding.Subject7Marks.text.toString() != "") &&
                        (binding.creditHours1.text.toString() != "") &&
                        (binding.creditHours2.text.toString() != "") &&
                        (binding.creditHours3.text.toString() != "") &&
                        (binding.creditHours4.text.toString() != "") &&
                        (binding.creditHours5.text.toString() != "") &&
                        (binding.creditHours6.text.toString() != "") && (binding.creditHours7.text.toString() != "")
                    ) {
                        if ((binding.creditHours1.text.toString()
                                .toInt() in (1..4)) && (binding.creditHours2.text.toString()
                                .toInt() in (1..4)) && (binding.creditHours3.text.toString()
                                .toInt() in (1..4)) && (binding.creditHours4.text.toString()
                                .toInt() in (1..4)) && (binding.creditHours5.text.toString()
                                .toInt() in (1..4)) && (binding.creditHours6.text.toString()
                                .toInt() in (1..4)) && binding.creditHours7.text.toString().toInt() in 1..4
                        ){
                            gpaCalculation(creditHours,marks,qp,grades)

                        }else {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
                        }

                    } else {
                        binding.GPALayout.visibility = View.GONE
                        binding.checkReportLayout.visibility = View.GONE
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "6" -> {
                    if ((binding.Subject1Marks.text.toString() != "") && (binding.Subject2Marks.text.toString() != "") && (binding.Subject3Marks.text.toString() != "") && (binding.Subject4Marks.text.toString() != "") && (binding.Subject5Marks.text.toString() != "") && (binding.Subject6Marks.text.toString() != "") && (binding.creditHours1.text.toString() != "") && (binding.creditHours2.text.toString() != "") && (binding.creditHours3.text.toString() != "") && (binding.creditHours4.text.toString() != "") && (binding.creditHours5.text.toString() != "") && (binding.creditHours6.text.toString() != ""))
                    {

                        if ((binding.creditHours1.text.toString()
                                .toInt() in 1..4) && (binding.creditHours2.text.toString()
                                .toInt() in 1..4) && (binding.creditHours3.text.toString()
                                .toInt() in 1..4) && (binding.creditHours4.text.toString()
                                .toInt() in 1..4) && (binding.creditHours5.text.toString()
                                .toInt() in 1..4) && (binding.creditHours6.text.toString().toInt() in 1..4)
                        ) {
                           gpaCalculation(creditHours,marks,qp,grades)
                        } else {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
                        }

                    }else {
                        binding.GPALayout.visibility = View.GONE
                        binding.checkReportLayout.visibility = View.GONE
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "5" -> {
                    if ((binding.Subject1Marks.text.toString() != "") && (binding.Subject2Marks.text.toString() != "") && (binding.Subject3Marks.text.toString() != "") && (binding.Subject4Marks.text.toString() != "") && (binding.Subject5Marks.text.toString() != "") && (binding.creditHours1.text.toString() != "") && (binding.creditHours2.text.toString() != "") && (binding.creditHours3.text.toString() != "") && (binding.creditHours4.text.toString() != "") && (binding.creditHours5.text.toString() != ""))
                    {
                        if ((binding.creditHours1.text.toString()
                                .toInt() in 1..4) && (binding.creditHours2.text.toString()
                                .toInt() in 1..4) && (binding.creditHours3.text.toString()
                                .toInt() in 1..4) && (binding.creditHours4.text.toString()
                                .toInt() in 1..4) && (binding.creditHours5.text.toString().toInt() in 1..4)
                        ) {

                            gpaCalculation(creditHours,marks,qp,grades)
                        } else {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
                        }


                    }else {
                        binding.GPALayout.visibility = View.GONE
                        binding.checkReportLayout.visibility = View.GONE
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }

                    }

                "4" -> {
                    if ((binding.Subject1Marks.text.toString() != "") && (binding.Subject2Marks.text.toString() != "") && (binding.Subject3Marks.text.toString() != "") && (binding.Subject4Marks.text.toString() != "") && (binding.creditHours1.text.toString() != "") && (binding.creditHours2.text.toString() != "") && (binding.creditHours3.text.toString() != "") && (binding.creditHours4.text.toString() != ""))
                    {

                        if ((binding.creditHours1.text.toString()
                                .toInt() in 1..4) && (binding.creditHours2.text.toString()
                                .toInt() in 1..4) && (binding.creditHours3.text.toString()
                                .toInt() in 1..4) && (binding.creditHours4.text.toString().toInt() in 1..4)
                        ) {
                            gpaCalculation(creditHours,marks,qp,grades)
                        } else {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
                        }

                    }else {
                        binding.GPALayout.visibility = View.GONE
                        binding.checkReportLayout.visibility = View.GONE
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "3" -> {
                    if ((binding.Subject1Marks.text.toString() != "") && (binding.Subject2Marks.text.toString() != "") && (binding.Subject3Marks.text.toString() != "") && (binding.creditHours1.text.toString() != "") && (binding.creditHours2.text.toString() != "") && (binding.creditHours3.text.toString() != "")) {


                        if ((binding.creditHours1.text.toString()
                                .toInt() in 1..4) && (binding.creditHours2.text.toString()
                                .toInt() in 1..4) && (binding.creditHours3.text.toString().toInt() in 1..4)
                        ) {
                            gpaCalculation(creditHours,marks,qp,grades)

                        }else {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
                        }

                    }else {
                        binding.GPALayout.visibility = View.GONE
                        binding.checkReportLayout.visibility = View.GONE
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "2" -> {
                    if ((binding.Subject1Marks.text.toString() != "") && (binding.Subject2Marks.text.toString() != "") && (binding.creditHours1.text.toString() != "") && (binding.creditHours2.text.toString() != "")) {


                        if ((binding.creditHours1.text.toString()
                                .toInt() in 1..4) && (binding.creditHours2.text.toString().toInt() in 1..4)
                        ) {
                            gpaCalculation(creditHours,marks,qp,grades)
                        } else {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
                        }
                    }else {
                        binding.GPALayout.visibility = View.GONE
                        binding.checkReportLayout.visibility = View.GONE
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "1" -> {
                    if ((binding.Subject1Marks.text.toString() != "") && (binding.creditHours1.text.toString() != "")) {
                        if ((binding.creditHours1.text.toString().toInt() in 1..4)) {
                            gpaCalculation(creditHours,marks,qp,grades)
                        }else {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
                        }
                    }else {
                        binding.GPALayout.visibility = View.GONE
                        binding.checkReportLayout.visibility = View.GONE
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                } else -> Toast.makeText(activity,"Invalid No.Of Subjects",Toast.LENGTH_SHORT).show()
            }
//            sharedViewModel.getGrades(grades)
        }

    }
    private fun gpaCalculation(creditHours: Array<String>, marks: Array<String>, qp: Array<String>, grades: Array<String>) {
                var totalQP = 0.0.toFloat()
                var totalCredit = 0
                for (i in 0 until noOfSubjects.toInt()) {
                    if (creditHours[i] == "4") {
                        val om4 = marks[i]
                        qp[i] = ch4(om4).toString()
                        grades[i] = calculateGrade(om4, creditHours[i])
                    } else if (creditHours[i] == "3") {
                        val om3 = marks[i]
                        qp[i] = ch3(om3).toString()
                        grades[i] = calculateGrade(om3, creditHours[i])
                    } else if (creditHours[i] == "2") {
                        val om2 = marks[i]
                        qp[i] = ch2(om2).toString()
                        grades[i] = calculateGrade(om2, creditHours[i])
                    } else if (creditHours[i] == "1") {
                        val om1 = marks[i]
                        qp[i] = ch1(om1).toString()
                        grades[i] = calculateGrade(om1, creditHours[i])
                    }
                }

                for (i in 0 until noOfSubjects.toInt()) {
                    totalQP += qp[i].toFloat()
                }
                for (i in 0 until noOfSubjects.toInt()) {
                    totalCredit += creditHours[i].toInt()
                }
                val gpa = totalQP / totalCredit
                "%.2f".format(gpa).toFloat().toString().also { GPA = it }
                gpa_text.finalGPA = GPA
                totalCreditsEarned = totalCredit.toString()
                for (i in 0 until noOfSubjects.toInt()) {
                    when (qp[i]) {
                        0.5.toString() -> {
                            binding.GPALayout.visibility = View.GONE
                            binding.checkReportLayout.visibility = View.GONE
                            Toast.makeText(activity, "Invalid Marks", Toast.LENGTH_SHORT).show()
                            break
                        }

                        else -> {
                            binding.GPALayout.visibility = View.VISIBLE
                            binding.checkReportLayout.visibility = View.VISIBLE
                        }
                    }
                }
    }

    fun calculateGrade(obtainedMarks: String, creditHours: String): String {
        when (creditHours) {
            "1" -> {
                return if (obtainedMarks.toInt() in 16..20) "A"
                else if (obtainedMarks.toInt() in 13..15) "B"
                else if (obtainedMarks.toInt() in 10..12) "C"
                else if (obtainedMarks.toInt() in 8..9) "D"
                else "F"
            }

            "2" -> {
                return if (obtainedMarks.toInt() in 32..40) "A"
                else if (obtainedMarks.toInt() in 26..31) "B"
                else if (obtainedMarks.toInt() in 20..25) "C"
                else if (obtainedMarks.toInt() in 16..19) "D"
                else "F"
            }

            "3" -> {
                return if (obtainedMarks.toInt() in 48..60) "A"
                else if (obtainedMarks.toInt() in 39..47) "B"
                else if (obtainedMarks.toInt() in 30..38) "C"
                else if (obtainedMarks.toInt() in 24..29) "D"
                else "F"
            }

            "4" -> {
                return if (obtainedMarks.toInt() in 64..80) "A"
                else if (obtainedMarks.toInt() in 52..63) "B"
                else if (obtainedMarks.toInt() in 40..51) "C"
                else if (obtainedMarks.toInt() in 32..39) "D"
                else "F"
            }

            else -> return "F"
        }
    }

}

private fun ch4(om4: String): Float {
    if (om4.toInt() <= 80) {
        if (om4.toInt() in 32..80) {
            val qualityPoints = arrayOf(
                16,
                15.67,
                15.33,
                15,
                14.67,
                14.33,
                14,
                13.67,
                13.33,
                13,
                12.67,
                12.33,
                12,
                11.67,
                11.33,
                11,
                10.67,
                10.33,
                10,
                9.67,
                9.33,
                9,
                8.67,
                8.33,
                8,
                7.5,
                7,
                6.5,
                6,
                5.5,
                5,
                4.5,
                4
            )
            var a1 = "64".toInt() // minimum marks to get the A grade for 4 credit subject
            lateinit var qp4: String
            for (i in 0..32) {
                if ((om4.toInt() in a1..80)) {
                    qp4 = qualityPoints[i].toString()
                    break
                } else
                    if (om4.toInt() == a1) {
                        qp4 = qualityPoints[i].toString()
                        break
                    }
                a1--
            }
            return qp4.toFloat()
        } else return 0.0.toFloat()
    } else return 0.5.toFloat()
}

// This function will calculate the quality points for the Subject with 3 credit hours.
private fun ch3(om3: String): Float {
    if (om3.toInt() <= 60) {
        if (om3.toInt() in 25..60) {
            val qualityPoints = arrayOf(
                12,
                11.67,
                11.33,
                11,
                10.67,
                10.33,
                10,
                9.67,
                9.33,
                9,
                8.67,
                8.33,
                8,
                7.67,
                7.33,
                7,
                6.67,
                6.33,
                6,
                5.5,
                5,
                4.5,
                4,
                3.5,
                3
            )
            lateinit var qp3: String
            var a1 = 48
            var i = 0 // Counter for the loop
            while (i <= 25) {
                if ((om3.toInt() in a1..60)) {
                    qp3 = qualityPoints[i].toString()
                    break
                } else {
                    if (om3 == a1.toString()) {
                        qp3 = qualityPoints[i].toString()
                        break
                    }
                }
                a1--
                i++
            }
            return qp3.toFloat()
        } else return 0.0.toFloat()
    } else return 0.5.toFloat()
}

// This function will calculate the quality points for the Subject with 2 credit hours.
private fun ch2(om2: String): Float {
    if (om2.toInt() <= 40) {
        if (om2.toInt() in 16..40) {
            val qualityPoints = arrayOf(
                8, 7.67, 7.33, 7, 6.67, 6.33, 6, 5.67, 5.33, 5, 4.67, 4.33, 4, 3.5, 3, 2.5, 2
            )
            lateinit var qp2: String
            var i = 0 // counter for the loop
            var a1 = 32 // minimum marks to get the A grade for 2 credit hour subject
            while (i <= 16) {
                if ((om2.toInt() in a1..40)) {
                    qp2 = qualityPoints[i].toString()
                    break
                } else {
                    if (om2 == a1.toString()) {
                        qp2 = qualityPoints[i].toString()
                        break
                    }
                }
                a1--
                i++
            }
            return qp2.toFloat()
        } else return 0.0.toFloat()
    } else return 0.5.toFloat()
}


private fun ch1(om1: String): Float {
    if (om1.toInt() <= 20) {
        if (om1.toInt() in 8..20) {
            val qualityPoints = arrayOf(
                4, 3.67, 3.33, 3, 2.67, 2.33, 2, 1.5, 1
            )
            lateinit var qp1: String
            var i = 0 // counter for the loop
            var a1 = 16 // minimum marks to get the A grade for 1 credit hour subject
            while (i <= 8) {
                if ((om1.toInt() in a1..40)) {
                    qp1 = qualityPoints[i].toString()
                    break
                } else {
                    if (om1 == a1.toString()) {
                        qp1 = qualityPoints[i].toString()
                        break
                    }
                }
                a1--
                i++
            }
            return qp1.toFloat()
        } else return 0.0.toFloat()
    } else return 0.5.toFloat()
}