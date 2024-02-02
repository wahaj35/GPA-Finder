package com.example.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {

    //MutableList for Marks
   private var marks = MutableList(6){""}
    var studentMarks: MutableList<String> = marks

    //MutableList for Subjects
    private var subjects = MutableList(6){""}
    var subjectsNames: MutableList<String> = subjects

    //Mutable List For CreditHours
    private var credits = MutableList(6){""}
    var creditHours: MutableList<String> = credits


    //Function to Set Subjects Names in the List
    fun setSubjects(subjects: Array<String>){
        for(i in 0..5){
            subjectsNames[i] = subjects[i]
        }

    }

    //Function to Set marks Names in the List
    fun setMarks(marks: Array<String>){
        for(i in 0..5){
            studentMarks[i] = marks[i]
        }

    }

    fun setCreditHours(credits:Array<String>){
        for(i in 0..5){
            creditHours[i] = credits[i]
        }
    }

}