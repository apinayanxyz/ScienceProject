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
        answerOneButton.setOnClickListener {
            if (answered==false) {
                fadeInButton()
                showCorrectAnswer()
                if (questionList?.get(questionNumber!!)?.correctAnswer == 1) {
                    questionList?.get(questionNumber!!)?.answered = "Correct"
                    score= score?.plus(10)
                } else {
                    questionList?.get(questionNumber!!)?.answered = "Incorrect"
                    answerOneButton.setBackgroundColor(resources.getColor(R.color.wrongRed))
                }
                answered = true
            }
        }
        answerTwoButton.setOnClickListener {
            if (answered==false) {
                fadeInButton()
                showCorrectAnswer()
                if (questionList?.get(questionNumber!!)?.correctAnswer == 2) {
                    questionList?.get(questionNumber!!)?.answered = "Correct"
                    score= score?.plus(10)
                } else {
                    questionList?.get(questionNumber!!)?.answered = "Incorrect"
                    answerTwoButton.setBackgroundColor(resources.getColor(R.color.wrongRed))
                }
                answered = true
            }
        }
        answerThreeButton.setOnClickListener {
            if (answered==false) {
                fadeInButton()
                showCorrectAnswer()
                if (questionList?.get(questionNumber!!)?.correctAnswer == 3) {
                    questionList?.get(questionNumber!!)?.answered = "Correct"
                    score= score?.plus(10)
                } else {
                    questionList?.get(questionNumber!!)?.answered = "Incorrect"
                    answerThreeButton.setBackgroundColor(resources.getColor(R.color.wrongRed))
                }
                answered = true
            }
        }
        answerFourButton.setOnClickListener {
            if (answered==false){
                fadeInButton()
                showCorrectAnswer()
            if (questionList?.get(questionNumber!!)?.correctAnswer == 4) {
                questionList?.get(questionNumber!!)?.answered = "Correct"
                score= score?.plus(10)
            } else {
                questionList?.get(questionNumber!!)?.answered = "Incorrect"
                answerFourButton.setBackgroundColor(resources.getColor(R.color.wrongRed))
            }
            answered = true
                }
        }




        nextButton.setOnClickListener{
            if (answered == true){
                if (questionNumber!! < maxQuestions!!.minus(1)) {
                    val questionIntent = Intent(this, QuestionsActivity::class.java)
                    questionIntent.putExtra("timeLimit", timeRemaining)
                    questionIntent.putExtra("maxQuestions", maxQuestions)
                    questionIntent.putExtra("questionNumber", questionNumber?.plus(1))
                    questionIntent.putExtra("score", score)
                    questionIntent.putExtra("subject", subject)
                    questionIntent.putExtra("questionList", questionListCreator)
                    startActivity(questionIntent)
                }
                else{
                    val scoreIntent = Intent(this, FinalScore::class.java)
                    scoreIntent.putExtra("timeRemaining", timeRemaining)
                    scoreIntent.putExtra("score", score)
                    scoreIntent.putExtra("subject", subject)
                    scoreIntent.putExtra("maxQuestions", maxQuestions)
                    scoreIntent.putExtra("questionList", questionListCreator)
                    startActivity(scoreIntent)
                }
            }
            else{
                answered = true
                nextButton.visibility = View.VISIBLE
            }
        }
    }
public override fun onBackPressed(){
    return;
    super.onBackPressed()

}
    private fun showCorrectAnswer() {
        val answerOneButton: Button = findViewById<Button>(R.id.answerOne)
        val answerTwoButton: Button = findViewById<Button>(R.id.answerTwo)
        val answerFourButton: Button = findViewById<Button>(R.id.answerThree)
        val answerThreeButton: Button = findViewById<Button>(R.id.answerFour)
        when (questionList?.get(questionNumber!!)?.correctAnswer) {
            1 -> {
                answerOneButton.setBackgroundColor(resources.getColor(R.color.correctGreen))
            }
            2 -> {
                answerTwoButton.setBackgroundColor(resources.getColor(R.color.correctGreen))
            }
            3 -> {
                answerThreeButton.setBackgroundColor(resources.getColor(R.color.correctGreen))
            }
            4 -> {
                answerFourButton.setBackgroundColor(resources.getColor(R.color.correctGreen))
            }
        }

    }

    private fun fadeInButton() {
        var nextButton: TextView = findViewById<TextView>(R.id.nextButton)
        val fadeInButton=AnimationUtils.loadAnimation(this,R.anim.fade_in_next_button)
        nextButton.startAnimation(fadeInButton)
        nextButton.visibility = View.VISIBLE
    }

    private fun timerCreation(extras: Bundle?) {
        var timerText: TextView = findViewById<TextView>(R.id.timerLabel)
        object : CountDownTimer (startTime!!,1000){
            override fun onTick(millisUntilFinished: Long) {
                if ((millisUntilFinished / 1000)%60>10) {
                    timerText.text =
                        "" + (millisUntilFinished / 1000) / 60 + ":" + (millisUntilFinished / 1000) % 60
                }
                else{

                    timerText.text =
                        "" + (millisUntilFinished / 1000) / 60 + ":0" + (millisUntilFinished / 1000) % 60
                }
                timeRemaining = timeRemaining?.minus(1000)
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                val scoreIntent = Intent(applicationContext, FinalScore::class.java)
                scoreIntent.putExtra("timeRemaining", timeRemaining)
                scoreIntent.putExtra("score", score)
                scoreIntent.putExtra("subject", subject)
                scoreIntent.putExtra("maxQuestions", maxQuestions)
                scoreIntent.putExtra("questionList", questionListCreator)
                startActivity(scoreIntent)
            }
        }.start()
    }

    @SuppressLint("ResourceAsColor")
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