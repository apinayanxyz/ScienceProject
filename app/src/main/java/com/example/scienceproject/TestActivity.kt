package com.example.scienceproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scienceproject.questionProcess.QuestionList
import com.example.scienceproject.questionProcess.QuestionsActivity

class TestActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    private var timePosition :Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test)
        supportActionBar?.hide()
        var value:Int? = null;
        val extras = intent.extras;
        if (extras != null) {
            value = extras . getInt ("testType");
        }
        if (value != null) {
            dynamicPage(value)
        }
        makeSpinner()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val timeSpinner = findViewById<Spinner>(R.id.testTimeSpinner)
        if (timeSpinner != null){
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,resources.getStringArray(R.array.time_array))
            timeSpinner.adapter = adapter

            timeSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    timePosition = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        var startButton = findViewById<Button>(R.id.testStartButton)

        startButton.setOnClickListener{
            //Grabs number of questions
            var questionNumber=30
            //Grabs amount of time for quiz
            var timeAmount:Long? =null
            println(timePosition)
            timeAmount =when(timePosition){
                0->30 * 60000
                1->45 * 60000
                else->50 * 60000
            }
            var questionList= QuestionList()
            questionList.questionList = questionList.createQuestions(questionNumber,value)
            //Items to send to next activity
            val questionIntent = Intent(this, QuestionsActivity::class.java)
            questionIntent.putExtra("timeLimit",timeAmount)
            questionIntent.putExtra("maxQuestions",questionNumber)
            questionIntent.putExtra("questionNumber",0)
            questionIntent.putExtra("score",0)
            questionIntent.putExtra("subject",value)
            questionIntent.putExtra("questionList",questionList)
            startActivity(questionIntent)

        }
    }    @SuppressLint("ResourceAsColor")
    private fun makeSpinner() {
        val timeSpinner = findViewById<Spinner>(R.id.testTimeSpinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.test_time_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            timeSpinner.adapter = adapter
        }

    }

    private fun dynamicPage(value:Int){
        when (value){
            1 -> {
                var backgroundOfTest = findViewById<FrameLayout>(R.id.testBackground)
                backgroundOfTest.background = resources.getColor(R.color.physicsColor).toDrawable()
                var subjectText = findViewById<TextView>(R.id.testSubjectText)
                subjectText.text = "Physics"
                subjectText.setTextColor(resources.getColor(R.color.white))
                var subjectLayout = findViewById<FrameLayout>(R.id.testSubjectLayout)
                subjectLayout.background = resources.getColor(R.color.physicsColor).toDrawable()
                var startButton = findViewById<Button>(R.id.testStartButton)
                startButton.setBackgroundColor(resources.getColor(R.color.physicsColor))
                startButton.setTextColor(resources.getColor(R.color.white))
            }
            2 -> {
                var backgroundOfTest = findViewById<FrameLayout>(R.id.testBackground)
                backgroundOfTest.background = resources.getColor(R.color.biologyColor).toDrawable()
                var subjectText = findViewById<TextView>(R.id.testSubjectText)
                subjectText.text = "Biology"
                subjectText.setTextColor(resources.getColor(R.color.white))
                var subjectLayout = findViewById<FrameLayout>(R.id.testSubjectLayout)
                subjectLayout.background = resources.getColor(R.color.biologyColor).toDrawable()
                var startButton = findViewById<Button>(R.id.testStartButton)
                startButton.setBackgroundColor(resources.getColor(R.color.biologyColor))
                startButton.setTextColor(resources.getColor(R.color.white))
            }
            3 -> {
                var backgroundOfTest = findViewById<FrameLayout>(R.id.testBackground)
                backgroundOfTest.background = resources.getColor(R.color.chemistryGreen).toDrawable()
                var subjectText = findViewById<TextView>(R.id.testSubjectText)
                subjectText.text = "Chemistry"
                subjectText.setTextColor(resources.getColor(R.color.chemistryTextColor))
                var subjectLayout = findViewById<FrameLayout>(R.id.testSubjectLayout)
                subjectLayout.background = resources.getColor(R.color.chemistryGreen).toDrawable()
                var startButton = findViewById<Button>(R.id.testStartButton)
                startButton.setBackgroundColor(resources.getColor(R.color.chemistryGreen))
                startButton.setTextColor(resources.getColor(R.color.chemistryTextColor))
            }
            else -> {
                var backgroundOfTest = findViewById<FrameLayout>(R.id.testBackground)
                backgroundOfTest.background = resources.getColor(R.color.all).toDrawable()
                var subjectText = findViewById<TextView>(R.id.testSubjectText)
                subjectText.text = "All"
                subjectText.setTextColor(resources.getColor(R.color.allText))
                var subjectLayout = findViewById<FrameLayout>(R.id.testSubjectLayout)
                subjectLayout.background = resources.getColor(R.color.all).toDrawable()
                var startButton = findViewById<Button>(R.id.testStartButton)
                startButton.setBackgroundColor(resources.getColor(R.color.all))
                startButton.setTextColor(resources.getColor(R.color.allText))
            }

        }
    }
}