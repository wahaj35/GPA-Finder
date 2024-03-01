package com.example.about

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.about.databinding.FragmentInputDataBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class gpaDataInput : Fragment() {
    lateinit var binding: FragmentInputDataBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var GPA: String
    private var indexing  = 0
    private var count = 0
    private var mInterstitialAd: InterstitialAd? = null
    private var trueToLoadAd: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_input_data, container, false)
        displayViews()
        binding.checkGPAButton.setOnClickListener {
            GPAChecker()
        }
        return binding.root
    }
private fun loadAD(){
    val adRequest = AdRequest.Builder().build()

    InterstitialAd.load(requireContext(),"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
        override fun onAdFailedToLoad(adError: LoadAdError) {
            adError.toString().let { Log.d(ContentValues.TAG, it) }
            mInterstitialAd = null
        }

        override fun onAdLoaded(interstitialAd: InterstitialAd) {
            Log.d(ContentValues.TAG, "Ad was loaded.")
            mInterstitialAd = interstitialAd
        }
    })
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
    private fun GPAChecker(){
        binding.apply {
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
            when(val checker = emptyStingChecker(marks,creditHours)){
                "Empty Marks Strings" -> Toast.makeText(context,checker,Toast.LENGTH_SHORT).show()
                "Empty Credit Hour String" -> Toast.makeText(context,checker,Toast.LENGTH_SHORT).show()
                "Empty Both Marks & Credit Strings" -> Toast.makeText(context,checker,Toast.LENGTH_SHORT).show()
                "Not Empty" -> {
                    when(val check =  valid_invalidCreditChecker(creditHours)){
                        "Invalid Credit Hours" -> {
                            if(count == 1) {
                                Toast.makeText(context,"Invalid Subject $indexing Credit Hours",Toast.LENGTH_SHORT).show()
                                count --
                            }
                            else {
                                Toast.makeText(context,"Invalid Multiple Credit Inputs including Subject $indexing Credits",Toast.LENGTH_SHORT).show()
                                count -= 2
                            }
                        }
                        else -> {
                         val isTrue = gpaCalculation(creditHours,marks,qp,grades)
                            if(isTrue) {
                                loadAD()
                                mInterstitialAd?.show(requireActivity())
                                view?.findNavController()?.navigate(R.id.action_dataInput_to_resultFragment)
                            }
                            else {
                                for(i in qp.indices){
                                    if(qp[i].toDouble() == 0.5){
                                        Toast.makeText(context,"Invalid Subject ${i+1} Marks",Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private fun valid_invalidCreditChecker(
        creditHours: Array<String>
    ) :String{
        var num  = 0
        for(i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()){
            if(creditHours[i].toFloat().toInt()in 1 ..4){
                num++
            } else{
                indexing = i+1
                count++
            }
        }
        return if(num == sharedViewModel.noOf_subjects.value.toString().toInt()) "Valid"
        else "Invalid Credit Hours"
    }
    private fun emptyStingChecker(
        marks: Array<String>,
        creditHours: Array<String>
    ): String {
        binding.apply {
            lateinit var checker: String // This will track if one of the GPA or Credit Strings is empty
            var num = 0 // This will track if both GPA and credits are empty
            for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
                if (marks[i] == "") {
                    checker = "Empty Marks Strings"
                    num++
                    break
                }
            }
            for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
                if (creditHours[i] == "") {
                    checker = "Empty Credit Hour String"
                    num++
                    break
                }
            }
            if (num == 2) checker = "Empty Both Marks & Credit Strings"
            if (num == 0) checker = "Not Empty"
            return checker
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
            val credits = creditHours[i].toFloat().toInt()

            when (credits) {
                4 -> {
                    val om4 = marks[i].toFloat().toInt()
                    qp[i] = ch4(om4).toString()
                    grades[i] = calculateGrade(om4, credits)
                }
                3 -> {
                    val om3 = marks[i].toFloat().toInt()
                    qp[i] = ch3(om3).toString()
                    grades[i] = calculateGrade(om3, credits)

                }
                2 -> {
                    val om2 = marks[i].toFloat().toInt()
                    qp[i] = ch2(om2).toString()
                    grades[i] = calculateGrade(om2, credits)

                }
                1 -> {
                    val om1 = marks[i].toFloat().toInt()
                    qp[i] = ch1(om1).toString()
                    grades[i] = calculateGrade(om1,credits)
                }
            }
        }

        for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
            totalQP += qp[i].toFloat()
        }
        for (i in 0 until sharedViewModel.noOf_subjects.value.toString().toInt()) {
            totalCredit += creditHours[i].toFloat().toInt()
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

    private fun calculateGrade(obtainedMarks: Int, creditHours: Int): String {
        when (creditHours) {
            1 -> {
                return when (obtainedMarks) {
                    in 16..20 -> "A"
                    in 13..15 -> "B"
                    in 10..12 -> "C"
                    in 8..9 -> "D"
                    else -> "F"
                }
            }

            2 -> {
                return when (obtainedMarks) {
                    in 32..40 -> "A"
                    in 26..31 -> "B"
                    in 20..25 -> "C"
                    in 16..19 -> "D"
                    else -> "F"
                }
            }

            3 -> {
                return when (obtainedMarks) {

                    in 48..60 -> "A"
                    in 39..47 -> "B"
                    in 30..38 -> "C"
                    in 24..29 -> "D"
                    else -> "F"
                }
            }

            4 -> {
                return when (obtainedMarks) {
                    in 64..80 -> "A"
                    in 52..63 -> "B"
                    in 40..51 -> "C"
                    in 32..39 -> "D"
                    else -> "F"
                }
            }
            else -> return "F"
        }
    }

}

private fun ch4(om4: Int): Float {
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
private fun ch3(om3: Int): Float {
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
                    if (om3 == a1) {
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
private fun ch2(om2: Int): Float {
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
                    if (om2 == a1) {
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


private fun ch1(om1: Int): Float {
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
                    if (om1 == a1) {
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