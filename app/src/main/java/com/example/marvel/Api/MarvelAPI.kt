package com.example.marvel.Api

import com.example.marvel.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int? =null,
        @Query("limit") limit: Int? =null,
        @Query("nameStartsWith") name: String? =null
    ): Response
}