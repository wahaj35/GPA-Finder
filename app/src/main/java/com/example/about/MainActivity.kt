package com.example.about

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.about.databinding.ActivityMainBinding

lateinit var noOfSubjects: String // The variable to store the no.of subjects entered by user

open class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private val gpa_text = GPA()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Binding all the data classes to the ActivityMainClass
        bind.gpaText = gpa_text
        // Setting up setOnClickListener on the buttons.
        bind.apply {
            // Setting up setOnClickLick method for the layout to view according to the user input
            enterButton.setOnClickListener { view() }
            // Setting up setOnClickLick method for the GPA Button
            checkGPAButton.setOnClickListener { chkGPA() }
        }
    }

    // This function which will be called only when the user input the No.of Subjects enter button. And will show layout according to the input
    @SuppressLint("ResourceAsColor", "SuspiciousIndentation")
    private fun view() {
        noOfSubjects = bind.noOfSubjectsInputBar.text.toString()
        val layouts = arrayOf(
            bind.layout1,
            bind.layout2,
            bind.layout3,
            bind.layout4,
            bind.layout5,
            bind.layout6,
        )

            val marks = arrayOf(
                bind.Subject1Marks,
                bind.Subject2Marks,
                bind.Subject3Marks,
                bind.Subject4Marks,
                bind.Subject5Marks,
                bind.Subject6Marks
            )
            val credits = arrayOf(
                bind.creditHours1,
                bind.creditHours2,
                bind.creditHours3,
                bind.creditHours4,
                bind.creditHours5,
                bind.creditHours6
            )
                when (noOfSubjects) {
                    "1" -> {
                        bind.scrollView2.visibility = View.VISIBLE
                        for (i in 0 until 6) {
                            if(i == 0) layouts[i].visibility = View.VISIBLE
                            else layouts[i].visibility = View.GONE
                            marks[i].setText("")
                            credits[i].setText("")
                        }
                        bind.noOfSubjectsInputBar.setText("")
                        bind.subjectsAndMarksHeader.visibility = View.VISIBLE
                        bind.ButtonLayout.visibility = View.VISIBLE
                        bind.GPALayout.visibility = View.GONE
                    }

                    "2" -> {
                        bind.scrollView2.visibility = View.VISIBLE
                        for (i in 0 until 6) {
                            if (i in 0..1) layouts[i].visibility = View.VISIBLE
                            else layouts[i].visibility = View.GONE
                            marks[i].setText("")
                            credits[i].setText("")
                        }
                        bind.noOfSubjectsInputBar.setText("")
                        bind.subjectsAndMarksHeader.visibility = View.VISIBLE
                        bind.ButtonLayout.visibility = View.VISIBLE
                        bind.GPALayout.visibility = View.GONE
                    }

                    "3" -> {
                        bind.scrollView2.visibility = View.VISIBLE
                        for (i in 0 until 6) {
                            if (i in 0.. 2) layouts[i].visibility = View.VISIBLE
                            else layouts[i].visibility = View.GONE
                            marks[i].setText("")
                            credits[i].setText("")
                        }
                        bind.noOfSubjectsInputBar.setText("")
                        bind.subjectsAndMarksHeader.visibility = View.VISIBLE
                        bind.ButtonLayout.visibility = View.VISIBLE
                        bind.GPALayout.visibility = View.GONE
                    }

                    "4" -> {
                        bind.scrollView2.visibility = View.VISIBLE
                        for (i in 0 until 6) {
                            if (i in 0..3) layouts[i].visibility = View.VISIBLE
                            else layouts[i].visibility = View.GONE
                            marks[i].setText("")
                            credits[i].setText("")
                        }
                        bind.noOfSubjectsInputBar.setText("")
                        bind.subjectsAndMarksHeader.visibility = View.VISIBLE
                        bind.ButtonLayout.visibility = View.VISIBLE
                        bind.GPALayout.visibility = View.GONE
                    }

                    "5" -> {
                        bind.scrollView2.visibility = View.VISIBLE
                        for (i in 0 until 6) {
                            if (i in 0 .. 4) layouts[i].visibility = View.VISIBLE
                            else layouts[i].visibility = View.GONE
                            marks[i].setText("")
                            credits[i].setText("")
                        }
                        bind.noOfSubjectsInputBar.setText("")
                        bind.subjectsAndMarksHeader.visibility = View.VISIBLE
                        bind.ButtonLayout.visibility = View.VISIBLE
                        bind.GPALayout.visibility = View.GONE
                    }

                    "6" -> {
                        bind.scrollView2.visibility = View.VISIBLE
                        for (i in 0 until 6) {
                           layouts[i].visibility = View.VISIBLE
                            marks[i].setText("")
                            credits[i].setText("")
                        }
                        bind.noOfSubjectsInputBar.setText("")
                        bind.subjectsAndMarksHeader.visibility = View.VISIBLE
                        bind.ButtonLayout.visibility = View.VISIBLE
                        bind.GPALayout.visibility = View.GONE
                    }
                    else ->
                    {
                        for (i in 0 until 6) {
                            layouts[i].visibility = View.GONE
                            marks[i].setText("")
                            credits[i].setText("")
                        }
                        bind.noOfSubjectsInputBar.setText("")
                        bind.subjectsAndMarksHeader.visibility = View.GONE
                        bind.ButtonLayout.visibility = View.GONE
                        bind.GPALayout.visibility = View.GONE
                        Toast.makeText(this, "Invalid No.Of Subjects", Toast.LENGTH_SHORT).show()
                    }
                }
    }

    //This function will be called when the chkGPA button will be entered to calculate the GPA according to the given Input.
    @SuppressLint("ResourceAsColor")
    private fun chkGPA() {
        bind.apply {
            // Assigning the EditText Credit Hours and Marks to the Properties of the Marks and Credit Hours Class
            val qp = Array(6) { "" }
            val marks = arrayOf(
                Subject1Marks.text.toString(),
                Subject2Marks.text.toString(),
                Subject3Marks.text.toString(),
                Subject4Marks.text.toString(),
                Subject5Marks.text.toString(),
                Subject6Marks.text.toString()
            )
            val creditHours = arrayOf(
                creditHours1.text.toString(),
                creditHours2.text.toString(),
                creditHours3.text.toString(),
                creditHours4.text.toString(),
                creditHours5.text.toString(),
                creditHours6.text.toString()
            )
            this.invalidateAll()
            when (noOfSubjects) {
                "6" -> sixSubjects(creditHours, marks, qp)

                "5" -> fiveSubjects(creditHours, marks, qp)

                "4" -> fourSubjects(creditHours, marks, qp)

                "3" -> threeSubjects(creditHours, marks, qp)

                "2" -> twoSubjects(creditHours, marks, qp)

                "1" -> oneSubject(creditHours, marks, qp)
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun sixSubjects(creditHours: Array<String>, marks: Array<String>, qp: Array<String>) {
        if ((bind.Subject1Marks.text.toString() != "") && (bind.Subject2Marks.text.toString() != "") && (bind.Subject3Marks.text.toString() != "") && (bind.Subject4Marks.text.toString() != "") && (bind.Subject5Marks.text.toString() != "") && (bind.Subject6Marks.text.toString() != "") && (bind.creditHours1.text.toString() != "") && (bind.creditHours2.text.toString() != "") && (bind.creditHours3.text.toString() != "") && (bind.creditHours4.text.toString() != "") && (bind.creditHours5.text.toString() != "") && (bind.creditHours6.text.toString() != "")) {
            if ((bind.creditHours1.text.toString()
                    .toInt() in 2..4) && (bind.creditHours2.text.toString()
                    .toInt() in 2..4) && (bind.creditHours3.text.toString()
                    .toInt() in 2..4) && (bind.creditHours4.text.toString()
                    .toInt() in 2..4) && (bind.creditHours5.text.toString()
                    .toInt() in 2..4) && (bind.creditHours6.text.toString().toInt() in 2..4)
            ) {
                var totalQP = 0.0.toFloat()
                var totalCredit = 0
                for (i in creditHours.indices) {
                    if (creditHours[i] == "4") {
                        val om4 = marks[i]
                        qp[i] = ch4(om4).toString()
                    } else if (creditHours[i] == "3") {
                        val om3 = marks[i]
                        qp[i] = ch3(om3).toString()
                    } else if (creditHours[i] == "2") {
                        val om2 = marks[i]
                        qp[i] = ch2(om2).toString()
                    }
                }
                for (element in qp) {
                    totalQP += element.toFloat()
                }
                for (element in creditHours) {
                    totalCredit += element.toInt()
                }
                val gpa = totalQP / totalCredit
                gpa_text.finalGPA = "%.2f".format(gpa).toFloat().toString()
                for (element in qp) {
                    when (element) {
                        0.5.toString() -> {
                            bind.GPALayout.visibility = View.GONE
                            Toast.makeText(this, "Invalid Marks", Toast.LENGTH_SHORT).show()
                            break
                        }

                        else -> {
                            bind.GPALayout.visibility = View.VISIBLE
                        }
                    }
                }
            } else {
                bind.GPALayout.visibility = View.GONE
                Toast.makeText(this, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
            }
        } else {
            bind.GPALayout.visibility = View.GONE
            Toast.makeText(this, "Empty Input String", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun fiveSubjects(creditHours: Array<String>, marks: Array<String>, qp: Array<String>) {
        if ((bind.Subject1Marks.text.toString() != "") && (bind.Subject2Marks.text.toString() != "") && (bind.Subject3Marks.text.toString() != "") && (bind.Subject4Marks.text.toString() != "") && (bind.Subject5Marks.text.toString() != "") && (bind.creditHours1.text.toString() != "") && (bind.creditHours2.text.toString() != "") && (bind.creditHours3.text.toString() != "") && (bind.creditHours4.text.toString() != "") && (bind.creditHours5.text.toString() != "")) {
            if ((bind.creditHours1.text.toString()
                    .toInt() in 2..4) && (bind.creditHours2.text.toString()
                    .toInt() in 2..4) && (bind.creditHours3.text.toString()
                    .toInt() in 2..4) && (bind.creditHours4.text.toString()
                    .toInt() in 2..4) && (bind.creditHours5.text.toString().toInt() in 2..4)
            ) {
                var totalQP = 0.0.toFloat()
                var totalCredit = 0
                for (i in 0 until creditHours.size - 1) {
                    if (creditHours[i] == "4") {
                        val om4 = marks[i]
                        qp[i] = ch4(om4).toString()
                    } else if (creditHours[i] == "3") {
                        val om3 = marks[i]
                        qp[i] = ch3(om3).toString()
                    } else if (creditHours[i] == "2") {
                        val om2 = marks[i]
                        qp[i] = ch2(om2).toString()
                    }
                }
                for (i in 0 until qp.size - 1) {
                    totalQP += qp[i].toFloat()
                }
                for (i in 0 until creditHours.size - 1) {
                    totalCredit += creditHours[i].toInt()
                }
                val gpa = totalQP / totalCredit
                gpa_text.finalGPA = "%.2f".format(gpa).toFloat().toString()
                for (i in 0 until qp.size - 1) {
                    when (qp[i]) {
                        0.5.toString() -> {
                            bind.GPALayout.visibility = View.GONE
                            Toast.makeText(this, "Invalid Marks", Toast.LENGTH_SHORT).show()
                            break
                        }

                        else -> bind.GPALayout.visibility = View.VISIBLE
                    }
                }
            } else {
                bind.GPALayout.visibility = View.GONE
                Toast.makeText(this, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
            }
        } else {
            bind.GPALayout.visibility = View.GONE
            Toast.makeText(this, "Empty Input String", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun fourSubjects(creditHours: Array<String>, marks: Array<String>, qp: Array<String>) {
        if ((bind.Subject1Marks.text.toString() != "") && (bind.Subject2Marks.text.toString() != "") && (bind.Subject3Marks.text.toString() != "") && (bind.Subject4Marks.text.toString() != "") && (bind.creditHours1.text.toString() != "") && (bind.creditHours2.text.toString() != "") && (bind.creditHours3.text.toString() != "") && (bind.creditHours4.text.toString() != "")) {
            if ((bind.creditHours1.text.toString()
                    .toInt() in 2..4) && (bind.creditHours2.text.toString()
                    .toInt() in 2..4) && (bind.creditHours3.text.toString()
                    .toInt() in 2..4) && (bind.creditHours4.text.toString().toInt() in 2..4)
            ) {
                var totalQP = 0.0.toFloat()
                var totalCredit = 0
                for (i in 0 until creditHours.size - 2) {
                    if (creditHours[i] == "4") {
                        val om4 = marks[i]
                        qp[i] = ch4(om4).toString()
                    } else if (creditHours[i] == "3") {
                        val om3 = marks[i]
                        qp[i] = ch3(om3).toString()
                    } else if (creditHours[i] == "2") {
                        val om2 = marks[i]
                        qp[i] = ch2(om2).toString()
                    }
                }
                for (i in 0 until qp.size - 2) {
                    totalQP += qp[i].toFloat()
                }
                for (i in 0 until creditHours.size - 2) {
                    totalCredit += creditHours[i].toInt()
                }
                val gpa = totalQP / totalCredit
                gpa_text.finalGPA = "%.2f".format(gpa).toFloat().toString()
                for (i in 0 until qp.size - 2) {
                    when (qp[i]) {
                        0.5.toString() -> {
                            bind.GPALayout.visibility = View.GONE
                            Toast.makeText(this, "Invalid Marks", Toast.LENGTH_SHORT).show()
                            break
                        }

                        else -> bind.GPALayout.visibility = View.VISIBLE
                    }
                }
            } else {
                bind.GPALayout.visibility = View.GONE
                Toast.makeText(this, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
            }
        } else {
            bind.GPALayout.visibility = View.GONE
            Toast.makeText(this, "Empty Input String", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun threeSubjects(creditHours: Array<String>, marks: Array<String>, qp: Array<String>) {
        if ((bind.Subject1Marks.text.toString() != "") && (bind.Subject2Marks.text.toString() != "") && (bind.Subject3Marks.text.toString() != "") && (bind.creditHours1.text.toString() != "") && (bind.creditHours2.text.toString() != "") && (bind.creditHours3.text.toString() != "")) {
            if ((bind.creditHours1.text.toString()
                    .toInt() in 2..4) && (bind.creditHours2.text.toString()
                    .toInt() in 2..4) && (bind.creditHours3.text.toString().toInt() in 2..4)
            ) {
                var totalQP = 0.0.toFloat()
                var totalCredit = 0
                for (i in 0 until creditHours.size - 3) {
                    if (creditHours[i] == "4") {
                        val om4 = marks[i]
                        qp[i] = ch4(om4).toString()
                    } else if (creditHours[i] == "3") {
                        val om3 = marks[i]
                        qp[i] = ch3(om3).toString()
                    } else if (creditHours[i] == "2") {
                        val om2 = marks[i]
                        qp[i] = ch2(om2).toString()
                    }
                }
                for (i in 0 until qp.size - 3) {
                    totalQP += qp[i].toFloat()
                }
                for (i in 0 until creditHours.size - 3) {
                    totalCredit += creditHours[i].toInt()
                }
                val gpa = totalQP / totalCredit
                gpa_text.finalGPA = "%.2f".format(gpa).toFloat().toString()
                for (i in 0 until qp.size - 3) {
                    when (qp[i]) {
                        0.5.toString() -> {
                            bind.GPALayout.visibility = View.GONE
                            Toast.makeText(this, "Invalid Marks", Toast.LENGTH_SHORT).show()
                            break
                        }

                        else -> bind.GPALayout.visibility = View.VISIBLE
                    }
                }
            } else {
                bind.GPALayout.visibility = View.GONE
                Toast.makeText(this, "Invalid Credit Hour", Toast.LENGTH_SHORT).show()
            }
        } else {
            bind.GPALayout.visibility = View.GONE
            Toast.makeText(this, "Empty Input String", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun twoSubjects(creditHours: Array<String>, marks: Array<String>, qp: Array<String>) {
        if ((bind.Subject1Marks.text.toString() != "") && (bind.Subject2Marks.text.toString() != "") && (bind.creditHours1.text.toString() != "") && (bind.creditHours2.text.toString() != "")) {
            if ((bind.creditHours1.text.toString()
                    .toInt() in 2..4) && (bind.creditHours2.text.toString().toInt() in 2..4)
            ) {
                var totalQP = 0.0.toFloat()
                var totalCredit = 0
                for (i in 0 until creditHours.size - 4) {
                    if (creditHours[i] == "4") {
                        val om4 = marks[i]
                        qp[i] = ch4(om4).toString()
                    } else if (creditHours[i] == "3") {
                        val om3 = marks[i]
                        qp[i] = ch3(om3).toString()
                    } else if (creditHours[i] == "2") {
                        val om2 = marks[i]
                        qp[i] = ch2(om2).toString()
                    }
                }
                for (i in 0 until qp.size - 4) {
                    totalQP += qp[i].toFloat()
                }
                for (i in 0 until creditHours.size - 4) {
                    totalCredit += creditHours[i].toInt()
                }
                val gpa = totalQP / totalCredit
                gpa_text.finalGPA = "%.2f".format(gpa).toFloat().toString()
                for (i in 0 until qp.size - 4) {
                    when (qp[i]) {
                        0.5.toString() -> {
                            bind.GPALayout.visibility = View.GONE
                            Toast.makeText(this, "Invalid Marks", Toast.LENGTH_SHORT).show()
                            break
                        }

                        else -> bind.GPALayout.visibility = View.VISIBLE
                    }
                }
            } else {
                bind.GPALayout.visibility = View.GONE
                Toast.makeText(this, "Invalid Credit Hours", Toast.LENGTH_SHORT).show()
            }
        } else {
            bind.GPALayout.visibility = View.GONE
            Toast.makeText(this, "Empty Input String", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun oneSubject(creditHours: Array<String>, marks: Array<String>, qp: Array<String>) {
        if ((bind.Subject1Marks.text.toString() != "") && (bind.creditHours1.text.toString() != "")) {
            if ((bind.creditHours1.text.toString().toInt() in 2..4)) {
                var totalQP = 0.0.toFloat()
                var totalCredit = 0
                for (i in 0 until creditHours.size - 5) {
                    if (creditHours[i] == "4") {
                        val om4 = marks[i]
                        qp[i] = ch4(om4).toString()
                    } else if (creditHours[i] == "3") {
                        val om3 = marks[i]
                        qp[i] = ch3(om3).toString()
                    } else if (creditHours[i] == "2") {
                        val om2 = marks[i]
                        qp[i] = ch2(om2).toString()
                    }
                }
                for (i in 0 until qp.size - 5) {
                    totalQP += qp[i].toFloat()
                }
                for (i in 0 until creditHours.size - 5) {
                    totalCredit += creditHours[i].toInt()
                }
                val gpa = totalQP / totalCredit
                gpa_text.finalGPA = "%.2f".format(gpa).toFloat().toString()
                for (i in 0 until qp.size - 5) {
                    when (qp[i]) {
                        0.5.toString() -> {
                            bind.GPALayout.visibility = View.GONE
                            Toast.makeText(this, "Invalid Marks", Toast.LENGTH_SHORT).show()
                            break
                        }

                        else -> bind.GPALayout.visibility = View.VISIBLE
                    }
                }
            } else {
                bind.GPALayout.visibility = View.GONE
                Toast.makeText(this, "Invalid Credit Hours", Toast.LENGTH_SHORT).show()
            }
        } else {
            bind.GPALayout.visibility = View.GONE
            Toast.makeText(this, "Empty Input String", Toast.LENGTH_SHORT).show()
        }
    }
}

// This function will calculate the quality points for the Subject with 4 credit hours.
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