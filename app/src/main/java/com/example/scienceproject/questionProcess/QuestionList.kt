package com.example.scienceproject.questionProcess

import java.io.Serializable

class QuestionList :Serializable{
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


    //Shuffles list
    fun shuffleList(): List<Questions> {
        return questionList.shuffled()
    }


    //Checks if list is no random, then passes value to get list from certain subject
    private fun getSubjectQuestions(questionSubject: Int?):List<Questions> {
        questionList = when(questionSubject){
            1->{
                createSubList(questionSubject)
            }
            2->{
                createSubList(questionSubject)
            }
            3->{
                createSubList(questionSubject)
            }

            else->{
                questionList
            }
        }
        return questionList
    }



    //Creates List based on passed subject
    private fun createSubList(questionSubject: Int?):List<Questions> {
        var subList = mutableListOf<Questions>()
        for (i in questionList){
            if (i.questionSubject==questionSubject){
                subList.add(i)
            }
        }
        return subList
    }


    //Creates a smaller list to be used by the programmed, the list is cut and shuffled and only specific subject is gathered
    fun createQuestions(numberOfQuestions: Int,questionSubject: Int?):List<Questions>{
        questionList= getSubjectQuestions(questionSubject)
        questionList=questionList.shuffled()
        var smallerQuestionList = mutableListOf<Questions>()
        for (i in 0..<numberOfQuestions){
            smallerQuestionList.add(i,questionList[i])
        }
        return smallerQuestionList
    }
}