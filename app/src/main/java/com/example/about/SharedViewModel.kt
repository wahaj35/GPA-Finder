package com.example.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {

   private var marks = MutableLiveData<String>()
    val studentMarks: MutableLiveData<String> = marks

    fun setMarks(marks: String){
        studentMarks.value = marks
    }

}