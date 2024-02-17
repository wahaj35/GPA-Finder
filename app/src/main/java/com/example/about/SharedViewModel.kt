package com.example.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {


    //Mutable Live data for noOfSubjects
    private var noOfSubjects = MutableLiveData("")
    var noOf_subjects: MutableLiveData<String> = noOfSubjects

    //MutableList for Marks
    private var marks = MutableList(10) { "" }
    var studentMarks: MutableList<String> = marks

    //MutableList for Subjects
    private var subjects = MutableList(10) { "" }
    var subjectsNames: MutableList<String> = subjects


    //Mutable Live Data For Earned Credts
    private var EarnedCredits = MutableLiveData("")
    var creditsEarned: MutableLiveData<String> = EarnedCredits

    private var cgpa = MutableLiveData("")
    var finalCGPA :MutableLiveData<String> = cgpa

    private var totalCreditHours = MutableList(10){""}
    var totalCreditHoursSemesterList :MutableList<String> = totalCreditHours

    private var totalCredits = MutableLiveData("")
    var totalCreditHoursSemester :MutableLiveData<String> = totalCredits

    private var GPA = MutableList(10){""}
    var semesterGPA : MutableList<String> = GPA

    //Mutable Live Data For GPA
    private var gpa = MutableLiveData("")
    var finalGPA: MutableLiveData<String> = gpa

    private var semesterNo = MutableLiveData<String>("")
    var noOfSemester : MutableLiveData<String> = semesterNo

    //Mutable List for grades
    private var grades = MutableList(10) { "" }
    var courseGrades: MutableList<String> = grades

    fun setGPA(gpa:Array<String>){
        for (i in 0 until noOfSemester.value.toString().toInt()){
            semesterGPA[i] = gpa[i]
        }
    }

    fun setCreditHours(credits:Array<String>){
        for(i in 0 until noOfSemester.value.toString().toInt()){
            totalCreditHoursSemesterList[i] = credits[i]
        }
    }

    fun getGrades(grades: Array<String>) {
        for (i in 0 until noOf_subjects.value.toString().toInt()) {
            courseGrades[i] = grades[i]
        }
    }

    //Function to Set marks Names in the List
    fun setMarks(marks: Array<String>) {
        for (i in 0 until noOf_subjects.value.toString().toInt()) {
            studentMarks[i] = marks[i]
        }

    }

}