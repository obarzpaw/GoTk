package com.gotk.api

import House
import Character
import com.gotk.models.Book
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoTkAPIService {
    @GET("characters/{character_id}")
    suspend fun getCharacterById(@Path("character_id") id: Int) : Character

    @GET("characters")
    suspend fun getCharacterByName(@Query("name") name: String) : List<Character>

    @GET("books/{book_id}")
    suspend fun getBookById(@Path("book_id") id: Int) : Book

    @GET("houses/{house_id}")
    suspend fun getHouseById(@Path("house_id") id: Int) : House

    companion object Factory {
        fun create(): GoTkAPIService {
            val retrofit = Retrofit.Builder()
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://anapioficeandfire.com/api/")
                .build()

            return retrofit.create(GoTkAPIService::class.java)
        }
    }
}