package com.example.about

data class GPA( var finalGPA: String = "")
data class Marks(var marks: Array<String> = arrayOf("","","","","","")) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Marks

        return marks.contentEquals(other.marks)
    }

    override fun hashCode(): Int {
        return marks.contentHashCode()
    }
}


