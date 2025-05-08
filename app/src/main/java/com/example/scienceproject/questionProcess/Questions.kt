package com.example.scienceproject.questionProcess

import javax.security.auth.Subject

class Questions(id:Int,subject: Int,question:String,correctAnswer:Int,answer1:String,answer2:String,answer3:String,answer4:String,questionType:Int,questionHint:String) {
    var questionId : Int? = id
    var questionSubject: Int? = subject
    var question : String? = question
    var correctAnswer : Int? = correctAnswer
    var answer1 : String? = answer1
    var answer2 : String? = answer2
    var answer3 : String? = answer3
    var answer4 : String? = answer4
    var questionType : Int? = questionType
    var questionHint : String = questionHint

}