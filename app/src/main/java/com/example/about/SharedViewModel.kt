package com.example.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {

    //MutableList for Marks
   private var marks = MutableList(7){""}
    var studentMarks: MutableList<String> = marks

    //MutableList for Subjects
    private var subjects = MutableList(7){""}
    var subjectsNames: MutableList<String> = subjects

    //Mutable List For CreditHours
    private var credits = MutableList(7){""}
    var creditHours: MutableList<String> = credits

    //Mutable Live Data For Earned Credts
    private var EarnedCredits = MutableLiveData("")
    var creditsEarned :MutableLiveData<String> = EarnedCredits


    //Mutable Live Data For GPA
    private var gpa = MutableLiveData("")
    var finalGPA :MutableLiveData<String> = gpa

    private var noOfSubjects = MutableLiveData("")
    var noOf_subjects:MutableLiveData<String> = noOfSubjects

    fun getNoOfSubjects(noOfSubjects:String){
        noOf_subjects.value = noOfSubjects
    }


    //Function to Set Subjects Names in the List
    fun setSubjects(subjects: Array<String>){
        for(i in subjects.indices){
            subjectsNames[i] = subjects[i]
        }

    }

    //Function to Set marks Names in the List
    fun setMarks(marks: Array<String>){
        for(i in marks.indices){
            studentMarks[i] = marks[i]
        }

    }

    fun setCreditHours(credits:Array<String>){
        for(i in credits.indices){
            creditHours[i] = credits[i]
        }
    }

}