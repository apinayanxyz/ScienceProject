package com.example.scienceproject

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scienceproject.questionProcess.QuestionsActivity

class QuizActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    private var questionNoPosition :Int?=null
    private var timePosition :Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        supportActionBar?.hide();
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
        var startButton = findViewById<Button>(R.id.quizStartButton)
        startButton.setOnClickListener{
            var questionNumber=when(questionNoPosition){
                0-> 5
                1-> 10
                2-> 15
                3-> 20
                4-> 25
                5-> 30
                else -> 10
            }
            var timeAmount:Long? =null
            timeAmount =when(timePosition){
                0->50000
                1->100000
                2->150000
                3->200000
                4->300000
                5->450000
                else->50000
            }
            val questionIntent = Intent(this,QuestionsActivity::class.java)
            questionIntent.putExtra("timeLimit",timeAmount)
            questionIntent.putExtra("maxQuestions",questionNumber)
            questionIntent.putExtra("subject",value)
            startActivity(questionIntent)

        }
    }

    @SuppressLint("ResourceAsColor")
    private fun makeSpinner() {
        val questionSpinner = findViewById<Spinner>(R.id.questionSpinner)
        val timeSpinner = findViewById<Spinner>(R.id.timeSpinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.questions_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            questionSpinner.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.time_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            timeSpinner.adapter = adapter
        }

    }
    public fun itemSelectionQuestion(){
        val questionSpinner = findViewById<Spinner>(R.id.questionSpinner)
        if (questionSpinner != null){
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,resources.getStringArray(R.array.questions_array))
            questionSpinner.adapter = adapter

            questionSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>,
                                                view: View, position: Int, id: Long) {
                        questionNoPosition = position
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // write code to perform some action
                    }
            }
        }
    }

    public fun itemSelectionTime(){
        val timeSpinner = findViewById<Spinner>(R.id.timeSpinner)
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
    }

    private fun dynamicPage(value:Int){
         when (value){
             1 -> {
                 var backgroundOfQuiz = findViewById<FrameLayout>(R.id.quizBackground)
                 backgroundOfQuiz.background = resources.getColor(R.color.physicsColor).toDrawable()
                 var subjectText = findViewById<TextView>(R.id.subject)
                 subjectText.text = "Physics"
                 subjectText.setTextColor(resources.getColor(R.color.white))
                 var subjectLayout = findViewById<FrameLayout>(R.id.subjectLayout)
                 subjectLayout.background = resources.getColor(R.color.physicsColor).toDrawable()
                 var startButton = findViewById<Button>(R.id.quizStartButton)
                 startButton.setBackgroundColor(resources.getColor(R.color.physicsColor))
                 startButton.setTextColor(resources.getColor(R.color.white))
             }
             2 -> {
                 var backgroundOfQuiz = findViewById<FrameLayout>(R.id.quizBackground)
                 backgroundOfQuiz.background = resources.getColor(R.color.biologyColor).toDrawable()
                 var subjectText = findViewById<TextView>(R.id.subject)
                 subjectText.text = "Biology"
                 subjectText.setTextColor(resources.getColor(R.color.white))
                 var subjectLayout = findViewById<FrameLayout>(R.id.subjectLayout)
                 subjectLayout.background = resources.getColor(R.color.biologyColor).toDrawable()
                 var startButton = findViewById<Button>(R.id.quizStartButton)
                 startButton.setBackgroundColor(resources.getColor(R.color.biologyColor))
                 startButton.setTextColor(resources.getColor(R.color.white))
             }
             3 -> {
                 var backgroundOfQuiz = findViewById<FrameLayout>(R.id.quizBackground)
                 backgroundOfQuiz.background = resources.getColor(R.color.chemistryGreen).toDrawable()
                 var subjectText = findViewById<TextView>(R.id.subject)
                 subjectText.text = "Chemistry"
                 subjectText.setTextColor(resources.getColor(R.color.chemistryTextColor))
                 var subjectLayout = findViewById<FrameLayout>(R.id.subjectLayout)
                 subjectLayout.background = resources.getColor(R.color.chemistryGreen).toDrawable()
                 var startButton = findViewById<Button>(R.id.quizStartButton)
                 startButton.setBackgroundColor(resources.getColor(R.color.chemistryGreen))
                 startButton.setTextColor(resources.getColor(R.color.chemistryTextColor))
             }
             else -> {
                 var backgroundOfQuiz = findViewById<FrameLayout>(R.id.quizBackground)
                 backgroundOfQuiz.background = resources.getColor(R.color.all).toDrawable()
                 var subjectText = findViewById<TextView>(R.id.subject)
                 subjectText.text = "All"
                 subjectText.setTextColor(resources.getColor(R.color.allText))
                 var subjectLayout = findViewById<FrameLayout>(R.id.subjectLayout)
                 subjectLayout.background = resources.getColor(R.color.all).toDrawable()
                 var startButton = findViewById<Button>(R.id.quizStartButton)
                 startButton.setBackgroundColor(resources.getColor(R.color.all))
                 startButton.setTextColor(resources.getColor(R.color.allText))
             }

         }
     }
}