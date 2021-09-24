package com.example.smproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.smproject.utils.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)

        removeVowels()
        euroToRial()
        Log.d("text length", textView.getTextLength().toString())
        val list = arrayListOf(1, 2, 10, 100, 5)
        Log.d("divisible", list.getTenDivisible().toString())
        list.toString().toast(this)
    }

    private fun removeVowels() {
        var text = "hello dear!"
        text = text.deleteVowels()
        Log.d("removed vowels", text)
    }

    private fun euroToRial() {
        val rial = "2".euroToRial()
        Log.d("Rial", rial)
    }

}