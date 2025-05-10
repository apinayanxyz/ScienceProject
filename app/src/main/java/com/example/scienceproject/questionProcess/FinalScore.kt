package com.example.scienceproject.questionProcess

import GlobalVar
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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
import com.example.scienceproject.ui.home.HomeFragment
import javax.security.auth.Subject
import kotlin.math.max

class FinalScore : AppCompatActivity() {
    private var score:Int?=null
    private var subject:Int?=null
    private var maxQuestions:Int?=null
    private var timeRemaining:Long?=null
    private var correctQuestions:Int?=0
    private var questionListCreator:QuestionList? = null
    private var questionList:List<Questions>? = null
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_score)
        val extras = intent.extras;
        if (extras != null) {
            subject = extras.getInt("subject")
            score = extras.getInt("score")
            timeRemaining = extras.getLong("timeRemaining")
            maxQuestions = extras.getInt("maxQuestions")
            questionListCreator = extras.getSerializable("questionList") as? QuestionList
            questionList = questionListCreator?.questionList
        }
        if (GlobalVar.score==null){
            GlobalVar.score = 0
        }
        for(i in questionList!!){
            if (i.answered=="Correct"){
                correctQuestions = correctQuestions!! + 1
            }
        }
        if (correctQuestions==maxQuestions){
            score= score?.plus((score!! /4))
        }

        //Background
        var backgroundLayout=findViewById<FrameLayout>(R.id.backgroundLayout)
        backgroundLayout.background = when (subject){
            1-> resources.getColor(R.color.physicsColor).toDrawable()
            2->resources.getColor(R.color.biologyColor).toDrawable()
            3->resources.getColor(R.color.chemistryGreen).toDrawable()
            else->resources.getColor(R.color.biologyColor).toDrawable()
        }
        //Score Text
        var scoreText = findViewById<TextView>(R.id.finalScoreText)
        scoreText.text= "You've gotten$score"
        //Total score text
        GlobalVar.score= GlobalVar.score.plus(score!!)
        var totalScoreText = findViewById<TextView>(R.id.totalScoreText)
        totalScoreText.text="Total score is"+GlobalVar.score
        //Questions answered text
        var questionText = findViewById<TextView>(R.id.amountOfQuestionsAnsweredText)
        questionText.text= "You've gotten$correctQuestions out of $maxQuestions"
        //Timer Text
        var timerText = findViewById<TextView>(R.id.amountOTimeLeftText)
        if ((timeRemaining?.div(1000))!! %60>10) {
            questionText.text =
                "You had " + (timeRemaining!! / 1000) / 60 + ":" + (timeRemaining!! / 1000) % 60 +" left"
        }
        else {
            timerText.text =
                "You had " + (timeRemaining!! / 1000) / 60 + ":" + (timeRemaining!! / 1000) % 60 +" left"
        }
        if (subject==4){

        }
        var homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener{
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}