package com.example.smproject.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Api {
    companion object {
        fun getRetInterface(): RestInterface {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit.create(RestInterface::class.java)
        }
    }
}