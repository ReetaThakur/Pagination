package com.example.pagination.ui

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private fun getNetworkInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiCall.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    fun getApiService(): ApiCall = getNetworkInstance().create(ApiCall::class.java)
}