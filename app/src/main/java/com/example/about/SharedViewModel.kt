package com.example.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {


    //Mutable Live data for noOfSubjects
    private var noOfSubjects = MutableLiveData("")
    var noOf_subjects:MutableLiveData<String> = noOfSubjects

    //MutableList for Marks
   private var marks = MutableList(8){""}
    var studentMarks: MutableList<String> = marks

    //MutableList for Subjects
    private var subjects = MutableList(8){""}
    var subjectsNames: MutableList<String> = subjects

    //Mutable List For CreditHours
    private var credits = MutableList(8){""}
    var creditHours: MutableList<String> = credits

    //Mutable Live Data For Earned Credts
    private var EarnedCredits = MutableLiveData("")
    var creditsEarned :MutableLiveData<String> = EarnedCredits


    //Mutable Live Data For GPA
    private var gpa = MutableLiveData("")
    var finalGPA :MutableLiveData<String> = gpa


    //Mutable List for grades
    private var grades = MutableList(8){""}
    var courseGrades:MutableList<String> = grades

    fun getGrades(grades:Array<String>){
        for(i in courseGrades.indices){
            courseGrades[i] = grades[i]
        }
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