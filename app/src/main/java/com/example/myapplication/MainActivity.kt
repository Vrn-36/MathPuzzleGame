package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainGame(3, 0, 0)
    }
    private fun mainGame(lives:Int, score:Int, roundNo:Int) {
        val o1 = findViewById<TextView>(R.id.operator1)
        val o2 = findViewById<TextView>(R.id.operator2)
        val o3 = findViewById<TextView>(R.id.operator3)
        val o4 = findViewById<TextView>(R.id.operator4)
        val o5 = findViewById<TextView>(R.id.operator5)
        val a1 = findViewById<TextView>(R.id.answer1)
        val a2 = findViewById<TextView>(R.id.answer2)
        val a3 = findViewById<TextView>(R.id.answer3)
        val a4 = findViewById<TextView>(R.id.answer4)
        val a5 = findViewById<TextView>(R.id.answer5)
        val blank11 = findViewById<Button>(R.id.b11)
        val blank21 = findViewById<Button>(R.id.b21)
        val blank31 = findViewById<Button>(R.id.b31)
        val blank41 = findViewById<Button>(R.id.b41)
        val blank51 = findViewById<Button>(R.id.b51)
        val blank12 = findViewById<Button>(R.id.b12)
        val blank22 = findViewById<Button>(R.id.b22)
        val blank32 = findViewById<Button>(R.id.b32)
        val blank42 = findViewById<Button>(R.id.b42)
        val blank52 = findViewById<Button>(R.id.b52)
        val option1 = findViewById<Button>(R.id.option1)
        val option2 = findViewById<Button>(R.id.option2)
        val option3 = findViewById<Button>(R.id.option3)
        val option4 = findViewById<Button>(R.id.option4)
        val option5 = findViewById<Button>(R.id.option5)
        val option6 = findViewById<Button>(R.id.option6)
        val option7 = findViewById<Button>(R.id.option7)
        val option8 = findViewById<Button>(R.id.option8)
        val option9 = findViewById<Button>(R.id.option9)
        val option10 = findViewById<Button>(R.id.option10)
        val operatorBoxes = arrayOf<TextView>(o1, o2, o3, o4, o5)
        val answerBoxes = arrayOf<TextView>(a1, a2, a3, a4, a5)
        val lifeCounter = findViewById<TextView>(R.id.lives)
        val scoreCounter = findViewById<TextView>(R.id.score)
        val submitButton = findViewById<Button>(R.id.submit)
        //val columnOne = arrayOf<Button>(blank11, blank21, blank31, blank41, blank51)
        //val columnTwo = arrayOf<Button>(blank12, blank22, blank32, blank42, blank52)
        val blanks = arrayOf<Button>(blank11, blank21, blank31, blank41, blank51, blank12, blank22, blank32, blank42, blank52)
        val options = arrayOf<Button>(option1, option2, option3, option4, option5, option6, option7, option8, option9, option10)
        options.shuffle()
        var emptyBlanks = 0
        var optionSelected: Button? = null
        //val x: IntArray = intArrayOf(6, 9, 2, 10, 25)
        //val y: IntArray = intArrayOf(1, 7, 3,` 4, 5)
        //val operations: IntArray = intArrayOf(0, 1, 2, 2, 3)
        for (blank in blanks) {
            blank.text = "_"
            options[blanks.indexOf(blank)].isEnabled = true
            blank.isEnabled = true
        }
        "Lives left : $lives".also { lifeCounter.text = it }
        "Score : $score".also { scoreCounter.text = it }
        val x: IntArray = intArrayOf(0, 0, 0, 0, 0)
        val y: IntArray = intArrayOf(0, 0, 0, 0, 0)
        val operations = intArrayOf(0, 0, 0, 0, 0)
        for (i in (0..4)) {
            val v1 = (1..20).random()
            var v2 = (1..20).random()
            when ((0..3).random()) {
                0 -> {
                    operations[i] = 0
                }
                1 -> {
                    operations[i] = 1
                }
                2 -> {
                    operations[i] = 2
                }
                else -> {
                    for (j in (v1 - 1 downTo 1)) {
                        if (v1 % j == 0) {
                            v2 = j
                            operations[i] = 3
                            break
                        }
                    }
                }
            }
            x[i] = v1
            y[i] = v2
            Log.d("myTag", x.contentToString())
            Log.d("myTag", y.contentToString())
        }
        for (k in (0..9)){
            if (k<5) options[k].text = (x[k]).toString()
            else options[k].text = (y[k-5]).toString()
            options[k].setTextColor(Color.WHITE)
            options[k].setBackgroundColor(Color.BLUE)
            //if (columnOne[i].text.toString().toInt()>=10) columnOne[i].textSize = 10.0F
            //if (columnTwo[i].text.toString().toInt()>=10) columnTwo[i].textSize = 10.0F
            if (options[k].text.toString().toInt()>=10) options[k].textSize = 10.0F
        }
        for (i in (0..4)){
            when (operations[i]){
                0-> {
                    operatorBoxes[i].text = "+"
                    (x[i] + y[i]).toString().also { answerBoxes[i].text = it }
                }
                1 ->{
                    operatorBoxes[i].text = "-"
                    answerBoxes[i].text = (x[i] - y[i]).toString()
                }
                2 -> {
                    operatorBoxes[i].text = "X"
                    answerBoxes[i].text = (x[i] * y[i]).toString()
                }
                3 -> {
                    operatorBoxes[i].text = "/"
                    answerBoxes[i].text = (x[i] / y[i]).toString()
                }
            }
        }
        for (optionButton in options) {
            optionButton.setOnClickListener{ view ->
                if (optionSelected == null)
                    when (view.id) {
                        R.id.option1 -> {
                            option1.setBackgroundColor(Color.GRAY)
                            optionSelected = option1
                            //idOfOptionSelected = option1.id.toString()
                        }
                        R.id.option2 -> {
                            option2.setBackgroundColor(Color.GRAY)
                            optionSelected = option2
                            //optionSelected = option2.text.toString()
                            //idOfOptionSelected = option2.id.toString()
                        }
                        R.id.option3 -> {
                            option3.setBackgroundColor(Color.GRAY)
                            optionSelected = option3
                            //optionSelected = option3.text.toString()
                            //idOfOptionSelected = option3.id.toString()
                        }
                        R.id.option4 -> {
                            option4.setBackgroundColor(Color.GRAY)
                            optionSelected = option4
                            //optionSelected = option4.text.toString()
                            //idOfOptionSelected = option4.id.toString()
                        }
                        R.id.option5 -> {
                            option5.setBackgroundColor(Color.GRAY)
                            optionSelected = option5
                            //optionSelected = option5.text.toString()
                            //idOfOptionSelected = option5.id.toString()
                        }
                        R.id.option6 -> {
                            option6.setBackgroundColor(Color.GRAY)
                            optionSelected = option6
                            //optionSelected = option6.text.toString()
                            //idOfOptionSelected = option6.id.toString()
                        }
                        R.id.option7 -> {
                            option7.setBackgroundColor(Color.GRAY)
                            optionSelected = option7
                            //optionSelected = option7.text.toString()
                            //idOfOptionSelected = option7.id.toString()
                        }
                        R.id.option8 -> {
                            option8.setBackgroundColor(Color.GRAY)
                            optionSelected = option8
                            //optionSelected = option8.text.toString()
                            //idOfOptionSelected = option8.id.toString()
                        }
                        R.id.option9 -> {
                            option9.setBackgroundColor(Color.GRAY)
                            optionSelected = option9
                            //optionSelected = option9.text.toString()
                            //idOfOptionSelected = option9.id.toString()
                        }
                        R.id.option10 -> {
                            option10.setBackgroundColor(Color.GRAY)
                            optionSelected = option10
                            //optionSelected = option10.text.toString()
                            //idOfOptionSelected = option10.id.toString()
                        }
                    }
                }
            }
        }
        for (blank in blanks) {
            blank.setOnClickListener {
                if (optionSelected != null) {
                    blank.text = optionSelected?.text.toString()
                    if (blank.text.toString().toInt()>=10) blank.textSize = 10.0F
                    optionSelected?.setBackgroundColor(Color.BLUE)
                    optionSelected?.text = "_"
                    optionSelected?.isEnabled = false
                    blank.isEnabled = false
                    emptyBlanks -= 1
                    optionSelected = null
                }
            }
        }
        submitButton.setOnClickListener{
            if (emptyBlanks!=0) {
                var success = 1
                for (i in (0..4)){
                    when (operations[i]){
                        0-> {
                            if (blanks[i].text.toString().toInt() + blanks[i+5].text.toString().toInt() != x[i]+y[i]){
                                success -= 1
                            }
                        }
                        1 ->{
                            if (blanks[i].text.toString().toInt() - blanks[i+5].text.toString().toInt() != x[i]-y[i]) {
                                success -= 1
                            }
                        }
                        2 -> {
                            if (blanks[i].text.toString().toInt() * blanks[i+5].text.toString().toInt() != x[i]*y[i]){
                                success -= 1
                            }
                        }
                        3 -> {
                            if (blanks[i].text.toString().toInt() / blanks[i+5].text.toString().toInt() != x[i]/y[i]){
                                success -= 1
                            }
                        }
                    }
                }
                if (success == 1){
                    mainGame(lives, score+100+(10*roundNo), roundNo+1)
                    Toast.makeText(this@MainActivity, "Successfully Solved!", Toast.LENGTH_LONG).show()
                }
                else{
                    Log.d("myTag", "Failed")
                    if (lives-1 > 0){
                        Toast.makeText(this@MainActivity, "Sorry! Incorrect Answer(s)", Toast.LENGTH_LONG).show()
                        mainGame(lives-1, score, roundNo+1)
                    }
                    else{
                        Log.d("myTag", "Died")
                        Toast.makeText(this@MainActivity, "All lives lost! Game Over!", Toast.LENGTH_LONG).show()
                        finishAffinity()
                    }
                }
            }
            else{
                if (lives-1 > 0){
                    Toast.makeText(this@MainActivity, "All questions were not solved!", Toast.LENGTH_LONG).show()
                    mainGame(lives-1, score-(10*roundNo), roundNo+1)
                    }
                else {
                    Log.d("myTag", "Died")
                    Toast.makeText(this@MainActivity, "All lives lost! Game Over!", Toast.LENGTH_LONG).show()
                    finishAffinity()
                }
            }
        }
    }
}


