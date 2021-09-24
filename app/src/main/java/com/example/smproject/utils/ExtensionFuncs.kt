package com.example.smproject.utils

import android.content.Context
import android.widget.TextView
import android.widget.Toast

fun String.deleteVowels(): String {
    val result = StringBuilder()
    for (char in this) {
        if (!"aeiou".contains(char, true)) {
            result.append(char)
        }
    }
    return result.toString()
}

fun String.euroToRial(): String {
    val rial = this.toFloat()
    return (rial * 32450).toString() + " Rials"
}

fun TextView.getTextLength(): Int {
    return this.text.length
}

fun ArrayList<Int>.getTenDivisible(): ArrayList<Int> {
    val res = arrayListOf<Int>()
    this.forEach {
        if (it % 10 == 0) {
            res.add(it)
        }
    }
    return res
}

fun String.toast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}