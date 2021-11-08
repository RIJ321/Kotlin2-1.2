package com.example.kotlin2_12.ui.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin2_12.core.App
import com.example.kotlin2_12.data.remote.RetrofitClient
import com.example.kotlin2_12.model.Questions
import com.example.kotlin2_12.model.TriviaCategories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragmentViewModel : ViewModel() {

    private val api = App.client
    private var questionsAmount = 0
    private val questionsLiveData = MutableLiveData<Int>()

    fun getCategories(): MutableLiveData<TriviaCategories> {
        val liveData = MutableLiveData<TriviaCategories>()
        api.getCategories().enqueue(object : Callback<TriviaCategories> {
            override fun onResponse(
                call: Call<TriviaCategories>,
                response: Response<TriviaCategories>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<TriviaCategories>, t: Throwable) {
                print(t.localizedMessage)
            }
        })
        return liveData
    }

/*
    fun getQuestions(
        questionsAmount: Int,
        category: String,
        difficulty: String
    ): MutableLiveData<Questions> {

        val liveData = MutableLiveData<Questions>()
        api.getQuestions(questionsAmount, category, difficulty)
            .enqueue(object : Callback<Questions> {
                override fun onResponse(call: Call<Questions>, response: Response<Questions>) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<Questions>, t: Throwable) {
                    print(t.localizedMessage)
                }
            })
        return liveData
    }
*/
    fun setQuestionsAmount(questions: Int) {
        questionsAmount = questions
    }

    fun getQuestionsAmount(): LiveData<Int> {
        questionsLiveData.postValue(questionsAmount)
        return questionsLiveData
    }

}