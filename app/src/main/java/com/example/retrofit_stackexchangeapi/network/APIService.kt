package com.example.retrofit_stackexchangeapi.network

import com.example.retrofit_stackexchangeapi.model.QuestionTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    fun getQuestions(@Query("tagged") tags:String) : Call<QuestionTO>
}