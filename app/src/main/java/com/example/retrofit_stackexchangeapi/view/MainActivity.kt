package com.example.retrofit_stackexchangeapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_stackexchangeapi.R
import com.example.retrofit_stackexchangeapi.model.QuestionModel
import com.example.retrofit_stackexchangeapi.model.QuestionTO
import com.example.retrofit_stackexchangeapi.network.APIService
import com.example.retrofit_stackexchangeapi.network.RequestProvider
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private var mApiService: APIService? = null
    private var mAdapter: ListAdapter? = null
    private var mQuestions: MutableList<QuestionModel>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = RequestProvider.client.create(APIService::class.java)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = mQuestions?.let { ListAdapter(it) }
        recyclerView.adapter = mAdapter
        fetchQuestionsList()
    }

    private fun fetchQuestionsList() {
        val call = mApiService!!.getQuestions("android")
        call.enqueue(object : Callback, retrofit2.Callback<QuestionTO> {
            override fun onResponse(call: Call<QuestionTO>, response: Response<QuestionTO>) {
                val questions = response.body()
                if (questions != null) {
                    mQuestions?.addAll(questions.items!!)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<QuestionTO>, t: Throwable) {
                Log.e("MainActivity","Got error" + t.localizedMessage)
            }
        })
    }
}