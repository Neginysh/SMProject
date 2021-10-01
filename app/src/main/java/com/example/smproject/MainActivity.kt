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
import com.example.smproject.view.SearchFragment
import com.example.smproject.view.SearchMovieAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchFragment = SearchFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, searchFragment)
            .commit()

    }

}