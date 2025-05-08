package com.example.scienceproject.questionProcess

class QuestionList {


        /*Question Type
        * 0 is multiple choice
        * */
        var questionList = listOf(
        Questions(1,1,"Question 1",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(2,1,"Question 2",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(3,1,"Question 3",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(4,1,"Question 4",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(5,1,"Question 5",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(6,1,"Question 6",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(7,1,"Question 7",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(8,1,"Question 8",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(9,1,"Question 9",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(10,1,"Question 10",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(11,2,"Question 1",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(12,2,"Question 2",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(13,2,"Question 3",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(14,2,"Question 4",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(15,2,"Question 5",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(16,2,"Question 6",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(17,2,"Question 7",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(18,2,"Question 8",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(19,2,"Question 9",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(20,2,"Question 10",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(21,3,"Question 1",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(22,3,"Question 2",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(23,3,"Question 3",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(24,3,"Question 4",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(25,3,"Question 5",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(26,3,"Question 6",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(27,3,"Question 7",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(28,3,"Question 8",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(29,3,"Question 9",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),
        Questions(30,3,"Question 10",1,"Answer 1","Answer 2","Answer 3","Answer 4",0,"Hint"),

        )
    fun shuffleList(): List<Questions> {
        return questionList.shuffled()
    }

    fun createQuestions(numberOfQuestions: Int):List<Questions>{
        var smallerQuestionList = mutableListOf<Questions>()
        for (i in 0..numberOfQuestions){
            smallerQuestionList.add(i,questionList[i])
        }
        return smallerQuestionList
    }
}