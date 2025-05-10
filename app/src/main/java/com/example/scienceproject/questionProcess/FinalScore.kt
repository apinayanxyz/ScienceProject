package com.example.scienceproject.questionProcess

import GlobalVar
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scienceproject.R
import javax.security.auth.Subject

class FinalScore : AppCompatActivity() {
    var score:Int?=null
    var subject:Int?=null
    private var questionListCreator:QuestionList? = null
    private var questionList:List<Questions>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_score)
        val extras = intent.extras;
        if (extras != null) {
            subject = extras.getInt("subject")
            score = extras.getInt("score")
            questionListCreator = extras.getSerializable("questionList") as? QuestionList
            questionList = questionListCreator?.questionList
        }
        /*if (GlobalVar.score==null){
            GlobalVar.score = 0
        }

        GlobalVar.score= GlobalVar.score?.plus(1)!!
        var totalScoreText = findViewById<TextView>(R.id.totalScoreText)
        totalScoreText.text="Total score is"+GlobalVar.score*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}