package com.example.kotlin2_12.data.remote

import com.example.kotlin2_12.model.Questions
import com.example.kotlin2_12.model.TriviaCategories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApi {

    @GET("/api_category.php")
    fun getCategories(): Call<TriviaCategories>

    @GET("/api.php")
    fun getQuestions(
        @Query("amount") questionsAmount: Int?,
        @Query("category") category: String?,
        @Query("difficulty") difficulty: String?
    ): Call<Questions>
}