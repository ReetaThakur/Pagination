package com.example.pagination.ui

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    companion object {
        val BASE_URL = "https://rickandmortyapi.com/"
    }

    @GET("api/character")
    suspend fun getInstace(@Query("page")page:Int):ResponseDTO

}