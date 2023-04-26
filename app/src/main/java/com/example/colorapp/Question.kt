package com.example.colorapp

class Question {
    lateinit var que:String
    lateinit var ans:List<String>

    constructor(que: String, ans: List<String>) {
        this.que = que
        this.ans = ans
    }

    override fun toString(): String {
        return "Question(que='$que', ans=$ans)"
    }
}
//val questions:MutableList<Question>=mutableListo(
//        Question(que="What is yur namae?",ans=listof())
//)