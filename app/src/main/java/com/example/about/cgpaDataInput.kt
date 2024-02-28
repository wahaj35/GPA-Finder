package com.example.about

import android.app.Activity
import android.content.ContentValues.TAG
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
import com.example.about.databinding.ActivityMainBinding
import com.example.about.databinding.FragmentCgpaDataInputBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.MobileAds.initialize
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlin.properties.Delegates

class cgpaDataInput : Fragment() {
    lateinit var binding: FragmentCgpaDataInputBinding
    val sharedViewModel: SharedViewModel by activityViewModels()
    private var count = 0
    private var indexing = 0
    private var mInterstitialAd: InterstitialAd? = null
    private var trueToLoadAd: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cgpa_data_input, container, false)
        MobileAds.initialize(requireContext())

        binding.apply {
            val views = arrayOf(
                oneSemesterInputCardLayout,
                twoSemesterInputCardLayout,
                threeSemesterInputCardLayout,
                fourSemesterInputCardLayout,
                fiveSemesterInputCardLayout,
                sixSemesterInputCardLayout,
                sevenSemesterInputCardLayout,
                eightSemesterInputCardLayout,
                nineSemesterInputCardLayout,
                tenSemesterInputCardLayout
            )
            val gpaEditTextsStrings = arrayOf(
                enterGPAEditText1,
                enterGPAEditText2,
                enterGPAEditText3,
                enterGPAEditText4,
                enterGPAEditText5,
                enterGPAEditText6,
                enterGPAEditText7,
                enterGPAEditText8,
                enterGPAEditText9,
                enterGPAEditText10
            )
            val creditsEditTextStrings = arrayOf(
                enterTotalCredits1,
                enterTotalCredits2,
                enterTotalCredits3,
                enterTotalCredits4,
                enterTotalCredits5,
                enterTotalCredits6,
                enterTotalCredits7,
                enterTotalCredits8,
                enterTotalCredits9,
                enterTotalCredits10
            )

            for (i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()) {
                views[i].visibility = View.VISIBLE
            }

            checkCGPAButton.setOnClickListener {
                chkCGPA()
            }
            resetButton.setOnClickListener {
                for(i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()){
                    gpaEditTextsStrings[i].setText("")
                    creditsEditTextStrings[i].setText("")
                }
            }
            return root
        }
    }

    private fun loadAD(){
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(requireContext(),"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                adError.toString().let { Log.d(TAG, it) }
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })
    }

    private fun chkCGPA() {
        binding.apply {
            val gpaEditTextsStrings = arrayOf(
                enterGPAEditText1.text.toString(),
                enterGPAEditText2.text.toString(),
                enterGPAEditText3.text.toString(),
                enterGPAEditText4.text.toString(),
                enterGPAEditText5.text.toString(),
                enterGPAEditText6.text.toString(),
                enterGPAEditText7.text.toString(),
                enterGPAEditText8.text.toString(),
                enterGPAEditText9.text.toString(),
                enterGPAEditText10.text.toString()
            )
            val creditsEditTextStrings = arrayOf(
                enterTotalCredits1.text.toString(),
                enterTotalCredits2.text.toString(),
                enterTotalCredits3.text.toString(),
                enterTotalCredits4.text.toString(),
                enterTotalCredits5.text.toString(),
                enterTotalCredits6.text.toString(),
                enterTotalCredits7.text.toString(),
                enterTotalCredits8.text.toString(),
                enterTotalCredits9.text.toString(),
                enterTotalCredits10.text.toString()
            )
            when (val checker = emptyStingChecker(gpaEditTextsStrings, creditsEditTextStrings)) {
                "Empty GPA String" -> Toast.makeText(context, checker, Toast.LENGTH_SHORT).show()
                "Empty Credit String" -> Toast.makeText(context, checker, Toast.LENGTH_SHORT).show()
                "Empty Both GPA & Credit Strings" -> Toast.makeText(
                    context,
                    checker,
                    Toast.LENGTH_SHORT
                ).show()

                "Not Empty" -> {
                  val check =   valid_invalidGPAChecker(gpaEditTextsStrings)
                    if(check == "Valid") calculateCGPA(gpaEditTextsStrings,creditsEditTextStrings)
                    else{
                        if(count == 1) {
                            Toast.makeText(context,"Invalid Semester $indexing GPA",Toast.LENGTH_SHORT).show()
                            count --
                        }
                        else {
                            Toast.makeText(context,"Invalid Multiple GPA Inputs including Semester $indexing GPA",Toast.LENGTH_SHORT).show()
                            count -= 2
                        }
                    }
                }
            }
        }
    }

    private fun valid_invalidGPAChecker(
        gpaEditTextsStrings: Array<String>
    ) :String{
        var num  = 0
        for(i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()){
               if(gpaEditTextsStrings[i].toDouble()in 0.0 ..4.0){
                   num++
               }
               else {
                   count ++
                   indexing = i+1
               }
        }
        if(num == sharedViewModel.noOfSemester.value.toString().toInt()) return "Valid"
        else return "Invalid GPA"
    }

    private fun calculateCGPA(
        gpaEditTextsStrings: Array<String>,
        creditsEditTextStrings: Array<String>
    ) {
        var totalQP = 0.0
        var totalCredits = 0
        for(i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()){
            totalQP += gpaEditTextsStrings[i].toDouble()*creditsEditTextStrings[i].toDouble()
        }
        for(i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()){
            totalCredits += creditsEditTextStrings[i].toFloat().toInt()
        }
        var cgpa = totalQP/totalCredits
        val CGPA = "%.2f".format(cgpa)
        sharedViewModel.finalCGPA.value = CGPA
        sharedViewModel.totalCreditHoursSemester.value = totalCredits.toString()
        sharedViewModel.setCreditHours(creditsEditTextStrings)
        sharedViewModel.setGPA(gpaEditTextsStrings)
        loadAD()
        mInterstitialAd?.show(requireActivity())
        view?.findNavController()?.navigate(R.id.action_cgpaDataInput_to_cgpaResult)
    }

    private fun emptyStingChecker(
        gpaEditTexts: Array<String>,
        creditEditTexts: Array<String>
    ): String {
        binding.apply {
            lateinit var checker: String // This will track if one of the GPA or Credit Strings is empty
            var num = 0 // This will track if both GPA and credits are empty
            for (i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()) {
                if (gpaEditTexts[i] == "") {
                    checker = "Empty GPA String"
                    num++
                    break
                }
            }
            for (i in 0 until sharedViewModel.noOfSemester.value.toString().toInt()) {
                if (creditEditTexts[i] == "") {
                    checker = "Empty Credit String"
                    num++
                    break
                }
            }
            if (num == 2) checker = "Empty Both GPA & Credit Strings"
            if (num == 0) checker = "Not Empty"
            return checker
        }
    }
}