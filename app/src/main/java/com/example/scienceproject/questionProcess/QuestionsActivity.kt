package com.example.scienceproject.questionProcess

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scienceproject.R
import org.w3c.dom.Text

class QuestionsActivity : AppCompatActivity() {
    val questionId = 0;

    private var questionNumber:Int? =null
    private var maxQuestions:Int? = null
    private var timeRemaining:Long? = null
    private var subject:Int? = null
    private var score:Int? = null
    private var answered:Boolean? = null
    private var questionListCreator:QuestionList? = null
    private var questionList:List<Questions>? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val answerOneButton = findViewById<Button>(R.id.answerOne)
        val answerTwoButton = findViewById<Button>(R.id.answerTwo)
        val answerFourButton = findViewById<Button>(R.id.answerThree)
        val answerThreeButton = findViewById<Button>(R.id.answerFour)

        val questionNumberText = findViewById<TextView>(R.id.questionNumberLabel)
        val subjectText = findViewById<TextView>(R.id.subjectLabel)
        var timerText = findViewById<TextView>(R.id.timerLabel)
        val questionText = findViewById<TextView>(R.id.questionLabel)
        var nextButton = findViewById<TextView>(R.id.nextButton)

        var layout = findViewById<FrameLayout>(R.id.backgroundLayout)

        val extras = intent.extras;
        if (extras != null) {
            questionNumber = extras.getInt("questionNumber")
            maxQuestions = extras.getInt("maxQuestions")
            timeRemaining = extras.getLong("timeLimit")
            subject = extras.getInt("subject")
            score = extras.getInt("score")
            questionListCreator = extras.getSerializable("questionList") as? QuestionList
            questionList = questionListCreator?.questionList
            when(questionList?.get(questionNumber!!)?.questionSubject){
                1->layout.background = resources.getColor(R.color.physicsColor).toDrawable()
                2->layout.background = resources.getColor(R.color.biologyColor).toDrawable()
                3->layout.background = resources.getColor(R.color.chemistryGreen).toDrawable()
            }
        }

        object : CountDownTimer (timeRemaining!!,1000){
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = ""+(millisUntilFinished / 1000)/60 +":"+(millisUntilFinished / 1000)%60
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                timerText.text = "done!"
            }
        }.start()
    }
}