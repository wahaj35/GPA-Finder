package com.example.about

import com.example.about.databinding.FragmentDataInputBinding

var binding:FragmentDataInputBinding = TODO()

data class GPA( var finalGPA: String = "")
data class Data(
    var marks: Array<String> = arrayOf(binding.Subject1Marks.text.toString(), binding.Subject2Marks.text.toString(), binding.Subject3Marks.text.toString(), binding.Subject4Marks.text.toString(), binding.Subject5Marks.text.toString(), binding.Subject6Marks.text.toString()),
    var creditHours: Array<String> = arrayOf(binding.creditHours1.text.toString(), binding.creditHours2.text.toString(), binding.creditHours3.text.toString(), binding.creditHours4.text.toString(), binding.creditHours5.text.toString(), binding.creditHours6.text.toString()),
    var subjects: Array<String> = arrayOf(binding.Subject1.text.toString(),binding.Subject2.text.toString(),binding.Subject3.text.toString(), binding.Subject4.text.toString(), binding.Subject5.text.toString(), binding.Subject6.text.toString())
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Data

        if (!marks.contentEquals(other.marks)) return false
        if (!creditHours.contentEquals(other.creditHours)) return false
        return subjects.contentEquals(other.subjects)
    }

    override fun hashCode(): Int {
        var result = marks.contentHashCode()
        result = 31 * result + creditHours.contentHashCode()
        result = 31 * result + subjects.contentHashCode()
        return result
    }
}