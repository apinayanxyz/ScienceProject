package com.example.scienceproject.questionProcess

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scienceproject.MainActivity
import com.example.scienceproject.R
import com.example.scienceproject.TestActivity
import org.w3c.dom.Text

class QuestionsActivity : AppCompatActivity() {
    //Data variables
    private var questionNumber:Int? =null
    private var maxQuestions:Int? = null
    private var startTime:Long? = null
    private var timeRemaining:Long? = null
    private var subject:Int? = null
    private var score:Int? = null
    private var answered:Boolean? = false
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
        val extras = intent.extras;
        layoutOfQuestion(extras)
        timerCreation(extras)

        var nextButton: TextView = findViewById<TextView>(R.id.nextButton)
        nextButton.visibility = View.INVISIBLE
        val answerOneButton: Button = findViewById<Button>(R.id.answerOne)
        val answerTwoButton: Button = findViewById<Button>(R.id.answerTwo)
        val answerFourButton: Button = findViewById<Button>(R.id.answerThree)
        val answerThreeButton: Button = findViewById<Button>(R.id.answerFour)

        answerOneButton.setOnClickListener{
            val fadeInButton=AnimationUtils.loadAnimation(this,R.anim.fade_in_next_button)
            nextButton.startAnimation(fadeInButton)
            nextButton.visibility = View.VISIBLE
            answered = true
        }




        nextButton.setOnClickListener{
            if (answered == true){
                if (questionNumber!! < maxQuestions!!.minus(1)) {
                    val questionIntent = Intent(this, QuestionsActivity::class.java)
                    questionIntent.putExtra("timeLimit", timeRemaining)
                    questionIntent.putExtra("maxQuestions", maxQuestions)
                    questionIntent.putExtra("questionNumber", questionNumber?.plus(1))
                    questionIntent.putExtra("score", 0)
                    questionIntent.putExtra("subject", subject)
                    questionIntent.putExtra("questionList", questionListCreator)
                    startActivity(questionIntent)
                }
                else{
                    val questionIntent = Intent(this, MainActivity::class.java)
                    startActivity(questionIntent)
                }
            }
            else{
                answered = true
                nextButton.visibility = View.VISIBLE
            }
        }
    }

    private fun timerCreation(extras: Bundle?) {
        var timerText: TextView = findViewById<TextView>(R.id.timerLabel)
        object : CountDownTimer (startTime!!,1000){
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = ""+(millisUntilFinished / 1000)/60 +":"+(millisUntilFinished / 1000)%60
                timeRemaining= timeRemaining?.minus(1000)
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                timerText.text = "done!"
            }
        }.start()
    }

    private fun layoutOfQuestion(extras:Bundle?){
        //Buttons for answering
        val answerOneButton: Button = findViewById<Button>(R.id.answerOne)
        val answerTwoButton: Button = findViewById<Button>(R.id.answerTwo)
        val answerFourButton: Button = findViewById<Button>(R.id.answerThree)
        val answerThreeButton: Button = findViewById<Button>(R.id.answerFour)

        //Text on screen and key layout parts
        val questionNumberText: TextView = findViewById<TextView>(R.id.questionNumberLabel)
        val subjectText: TextView = findViewById<TextView>(R.id.subjectLabel)
        var timerText: TextView = findViewById<TextView>(R.id.timerLabel)
        val questionText: TextView = findViewById<TextView>(R.id.questionLabel)
        var nextButton: TextView = findViewById<TextView>(R.id.nextButton)

        //Background and other useful information
        var layout: FrameLayout = findViewById<FrameLayout>(R.id.backgroundLayout)

        if (extras != null) {
            questionNumber = extras.getInt("questionNumber")
            maxQuestions = extras.getInt("maxQuestions")
            startTime = extras.getLong("timeLimit")
            timeRemaining = extras.getLong("timeLimit")
            subject = extras.getInt("subject")
            score = extras.getInt("score")
            questionListCreator = extras.getSerializable("questionList") as? QuestionList
            questionList = questionListCreator?.questionList

            //Add Text to non buttons
            //--//
            //Question number
            questionNumberText.text=(questionNumber!! +1).toString()
            //Subject of question
            subjectText.text=when(questionList?.get(questionNumber!!)?.questionSubject){
                1->"Physics"
                2->"Biology"
                3->"Chemistry"
                else->"All"
            }
            //The question
            questionText.text=questionList?.get(questionNumber!!)?.question
            //--//
            //Sets text of next button
            if (questionNumber!! < maxQuestions!!.minus(1)){
                nextButton.text="Next"
            }
            else{
                nextButton.text="Finish"
            }

            //Text on answering buttons
            //--//
            //Button 1
            answerOneButton.text= questionList?.get(questionNumber!!)?.answer1
            //Button 2
            answerTwoButton.text= questionList?.get(questionNumber!!)?.answer2
            //Button 3
            answerThreeButton.text= questionList?.get(questionNumber!!)?.answer3
            //Button 4
            answerFourButton.text= questionList?.get(questionNumber!!)?.answer4
            //--//
            //Color Background
            when(questionList?.get(questionNumber!!)?.questionSubject){
                1->layout.background = resources.getColor(R.color.physicsColor).toDrawable()
                2->layout.background = resources.getColor(R.color.biologyColor).toDrawable()
                3->layout.background = resources.getColor(R.color.chemistryGreen).toDrawable()
            }
        }
    }
}