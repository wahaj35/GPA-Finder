package com.example.about

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.about.databinding.FragmentInputDataBinding

class gpaDataInput : Fragment() {
    lateinit var binding: FragmentInputDataBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var GPA: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_input_data, container, false)
        displayViews()
        binding.checkGPAButton.setOnClickListener { chkGPA() }
        return binding.root
    }

    private fun displayViews() {
        binding.apply {
            val views = arrayOf(
                oneInputCardLayout,
                twoInputCardLayout,
                threeInputCardLayout,
                fourInputCardLayout,
                fiveInputCardLayout,
                sixInputCardLayout,
                sevenInputCardLayout,
                eightInputCardLayout,
                nineInputCardLayout,
                tenInputCardLayout
            )
            val marksEditText = arrayOf(
                enterMarksEditText1,
                enterMarksEditText2,
                enterMarksEditText3,
                enterMarksEditText4,
                enterMarksEditText5,
                enterMarksEditText6,
                enterMarksEditText7,
                enterMarksEditText8,
                enterMarksEditText9,
                enterMarksEditText10
            )
            val creditEditText = arrayOf(
                enterCreditHours1,
                enterCreditHours2,
                enterCreditHours3,
                enterCreditHours4,
                enterCreditHours5,
                enterCreditHours6,
                enterCreditHours7,
                enterCreditHours8,
                enterCreditHours9,
                enterCreditHours10
            )
            checkGPAButton.visibility = View.VISIBLE
            resetButton.visibility = View.VISIBLE
            resetButton.setOnClickListener {
                for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
                    marksEditText[i].setText("")
                    creditEditText[i].setText("")
                }
            }
            for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
                views[i].visibility = View.VISIBLE
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun chkGPA() {
        binding.apply {
            // Assigning the EditText Credit Hours and Marks to the Properties of the Marks and Credit Hours Class
            val qp = Array(sharedViewModel.noOf_subjects.value.toString().toInt()) { "" }
            val grades = Array(sharedViewModel.noOf_subjects.value.toString().toInt()) { "" }
            val marks = arrayOf(
                enterMarksEditText1.text.toString(),
                enterMarksEditText2.text.toString(),
                enterMarksEditText3.text.toString(),
                enterMarksEditText4.text.toString(),
                enterMarksEditText5.text.toString(),
                enterMarksEditText6.text.toString(),
                enterMarksEditText7.text.toString(),
                enterMarksEditText8.text.toString(),
                enterMarksEditText9.text.toString(),
                enterMarksEditText10.text.toString(),
            )
            val creditHours = arrayOf(
                enterCreditHours1.text.toString(),
                enterCreditHours2.text.toString(),
                enterCreditHours3.text.toString(),
                enterCreditHours4.text.toString(),
                enterCreditHours5.text.toString(),
                enterCreditHours6.text.toString(),
                enterCreditHours7.text.toString(),
                enterCreditHours8.text.toString(),
                enterCreditHours9.text.toString(),
                enterCreditHours10.text.toString(),
            )
            sharedViewModel.setMarks(marks)
            this.invalidateAll()
            when (sharedViewModel.noOf_subjects.value) {


                "10" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") &&
                        (binding.enterMarksEditText2.text.toString() != "") &&
                        (binding.enterMarksEditText3.text.toString() != "") &&
                        (binding.enterMarksEditText4.text.toString() != "") &&
                        (binding.enterMarksEditText5.text.toString() != "") &&
                        (binding.enterMarksEditText6.text.toString() != "") &&
                        (binding.enterMarksEditText7.text.toString() != "") &&
                        (binding.enterMarksEditText8.text.toString() != "") &&
                        (binding.enterCreditHours1.text.toString() != "") &&
                        (binding.enterCreditHours2.text.toString() != "") &&
                        (binding.enterCreditHours3.text.toString() != "") &&
                        (binding.enterCreditHours4.text.toString() != "") &&
                        (binding.enterCreditHours5.text.toString() != "") &&
                        (binding.enterCreditHours6.text.toString() != "") &&
                        (binding.enterCreditHours7.text.toString() != "") &&
                        (binding.enterCreditHours8.text.toString() != "") &&
                        (binding.enterCreditHours9.text.toString() != "") && (binding.enterCreditHours10.text.toString() != "")
                    ) {
                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours2.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours3.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours4.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours5.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours6.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours7.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours8.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours9.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours10.text.toString()
                                .toInt() in (1..4))
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else  Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }



                "9" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") &&
                        (binding.enterMarksEditText2.text.toString() != "") &&
                        (binding.enterMarksEditText3.text.toString() != "") &&
                        (binding.enterMarksEditText4.text.toString() != "") &&
                        (binding.enterMarksEditText5.text.toString() != "") &&
                        (binding.enterMarksEditText6.text.toString() != "") &&
                        (binding.enterMarksEditText7.text.toString() != "") &&
                        (binding.enterMarksEditText8.text.toString() != "") &&
                        (binding.enterCreditHours1.text.toString() != "") &&
                        (binding.enterCreditHours2.text.toString() != "") &&
                        (binding.enterCreditHours3.text.toString() != "") &&
                        (binding.enterCreditHours4.text.toString() != "") &&
                        (binding.enterCreditHours5.text.toString() != "") &&
                        (binding.enterCreditHours6.text.toString() != "") &&
                        (binding.enterCreditHours7.text.toString() != "") &&
                        (binding.enterCreditHours8.text.toString() != "") && (binding.enterCreditHours9.text.toString() != "")
                    ) {
                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours2.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours3.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours4.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours5.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours6.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours7.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours8.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours9.text.toString()
                                .toInt() in (1..4))
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else  Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }



                "8" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") &&
                        (binding.enterMarksEditText2.text.toString() != "") &&
                        (binding.enterMarksEditText3.text.toString() != "") &&
                        (binding.enterMarksEditText4.text.toString() != "") &&
                        (binding.enterMarksEditText5.text.toString() != "") &&
                        (binding.enterMarksEditText6.text.toString() != "") &&
                        (binding.enterMarksEditText7.text.toString() != "") &&
                        (binding.enterMarksEditText8.text.toString() != "") &&
                        (binding.enterCreditHours1.text.toString() != "") &&
                        (binding.enterCreditHours2.text.toString() != "") &&
                        (binding.enterCreditHours3.text.toString() != "") &&
                        (binding.enterCreditHours4.text.toString() != "") &&
                        (binding.enterCreditHours5.text.toString() != "") &&
                        (binding.enterCreditHours6.text.toString() != "") &&
                        (binding.enterCreditHours7.text.toString() != "") && (binding.enterCreditHours8.text.toString() != "")
                    ) {
                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours2.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours3.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours4.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours5.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours6.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours7.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours8.text.toString()
                                .toInt() in (1..4))
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                           else  Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "7" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") &&
                        (binding.enterMarksEditText2.text.toString() != "") &&
                        (binding.enterMarksEditText3.text.toString() != "") &&
                        (binding.enterMarksEditText4.text.toString() != "") &&
                        (binding.enterMarksEditText5.text.toString() != "") &&
                        (binding.enterMarksEditText6.text.toString() != "") &&
                        (binding.enterMarksEditText7.text.toString() != "") &&
                        (binding.enterCreditHours1.text.toString() != "") &&
                        (binding.enterCreditHours2.text.toString() != "") &&
                        (binding.enterCreditHours3.text.toString() != "") &&
                        (binding.enterCreditHours4.text.toString() != "") &&
                        (binding.enterCreditHours5.text.toString() != "") &&
                        (binding.enterCreditHours6.text.toString() != "") &&
                        (binding.enterCreditHours7.text.toString() != "")
                    ) {
                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours2.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours3.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours4.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours5.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours6.text.toString()
                                .toInt() in (1..4)) && (binding.enterCreditHours7.text.toString()
                                .toInt() in (1..4))
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }


                "6" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") && (binding.enterMarksEditText2.text.toString() != "") && (binding.enterMarksEditText3.text.toString() != "") && (binding.enterMarksEditText4.text.toString() != "") && (binding.enterMarksEditText5.text.toString() != "") && (binding.enterMarksEditText6.text.toString() != "") && (binding.enterCreditHours1.text.toString() != "") && (binding.enterCreditHours2.text.toString() != "") && (binding.enterCreditHours3.text.toString() != "") && (binding.enterCreditHours4.text.toString() != "") && (binding.enterCreditHours5.text.toString() != "") && (binding.enterCreditHours6.text.toString() != "")) {

                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours2.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours3.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours4.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours5.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours6.text.toString()
                                .toInt() in 1..4)
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "5" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") && (binding.enterMarksEditText2.text.toString() != "") && (binding.enterMarksEditText3.text.toString() != "") && (binding.enterMarksEditText4.text.toString() != "") && (binding.enterMarksEditText5.text.toString() != "") && (binding.enterCreditHours1.text.toString() != "") && (binding.enterCreditHours2.text.toString() != "") && (binding.enterCreditHours3.text.toString() != "") && (binding.enterCreditHours4.text.toString() != "") && (binding.enterCreditHours5.text.toString() != "")) {
                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours2.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours3.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours4.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours5.text.toString()
                                .toInt() in 1..4)
                        ) {

                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }


                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }

                }

                "4" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") && (binding.enterMarksEditText2.text.toString() != "") && (binding.enterMarksEditText3.text.toString() != "") && (binding.enterMarksEditText4.text.toString() != "") && (binding.enterCreditHours1.text.toString() != "") && (binding.enterCreditHours2.text.toString() != "") && (binding.enterCreditHours3.text.toString() != "") && (binding.enterCreditHours4.text.toString() != "")) {

                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours2.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours3.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours4.text.toString()
                                .toInt() in 1..4)
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "3" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") && (binding.enterMarksEditText2.text.toString() != "") && (binding.enterMarksEditText3.text.toString() != "") && (binding.enterCreditHours1.text.toString() != "") && (binding.enterCreditHours2.text.toString() != "") && (binding.enterCreditHours3.text.toString() != "")) {


                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours2.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours3.text.toString()
                                .toInt() in 1..4)
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "2" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") && (binding.enterMarksEditText2.text.toString() != "") && (binding.enterCreditHours1.text.toString() != "") && (binding.enterCreditHours2.text.toString() != "")) {


                        if ((binding.enterCreditHours1.text.toString()
                                .toInt() in 1..4) && (binding.enterCreditHours2.text.toString()
                                .toInt() in 1..4)
                        ) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }

                "1" -> {
                    if ((binding.enterMarksEditText1.text.toString() != "") && (binding.enterCreditHours1.text.toString() != "")) {
                        if ((binding.enterCreditHours1.text.toString().toInt() in 1..4)) {
                            val isTrue = gpaCalculation(creditHours, marks, qp, grades)
                            if (isTrue) view?.findNavController()
                                ?.navigate(R.id.action_dataInput_to_resultFragment)
                            else Toast.makeText(context, "Invalid Marks", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(activity, "Invalid Credit Hour", Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        Toast.makeText(activity, "Empty Input String", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun gpaCalculation(
        creditHours: Array<String>,
        marks: Array<String>,
        qp: Array<String>,
        grades: Array<String>
    ): Boolean {
        var totalQP = 0.0.toFloat()
        var totalCredit = 0
        for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
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

        for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
            totalQP += qp[i].toFloat()
        }
        for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
            totalCredit += creditHours[i].toInt()
        }
        val gpa = totalQP / totalCredit
        GPA = "%.2f".format(gpa).toFloat().toString()
        sharedViewModel.finalGPA.value = GPA
        sharedViewModel.creditsEarned.value = totalCredit.toString()
        sharedViewModel.getGrades(grades)
        var cheker = true
        for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
            when (qp[i]) {
                0.5.toString() -> {
                    cheker = false
                    break
                }
            }
        }
        return cheker
    }

    private fun calculateGrade(obtainedMarks: String, creditHours: String): String {
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