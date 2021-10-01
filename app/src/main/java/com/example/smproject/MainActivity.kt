package com.example.smproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smproject.model.SearchMovieResponse
import com.example.smproject.network.API_KEY
import com.example.smproject.network.Api
import com.example.smproject.network.RestInterface
import com.example.smproject.utils.*
import com.example.smproject.view.SearchMovieAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private var adapter: SearchMovieAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var searchText: EditText? = null
    private var searchButton: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        searchText = findViewById(R.id.et_search)
        searchButton = findViewById(R.id.search)
        recyclerView?.layoutManager = LinearLayoutManager(applicationContext)



        searchButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                getSearchList()
            }

        })


    }

    fun getSearchList() {
        Api.getRetInterface().searchMovieByTitle(searchText?.text.toString(), API_KEY)
            .enqueue(object : Callback<SearchMovieResponse> {
                override fun onResponse(
                    call: Call<SearchMovieResponse>,
                    response: Response<SearchMovieResponse>
                ) {
                    adapter = SearchMovieAdapter(response.body()?.Search)
                    recyclerView?.adapter = adapter

                    adapter?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
                    Log.d("FAILED TAG", t.message.toString())
                }

            })
    }

}