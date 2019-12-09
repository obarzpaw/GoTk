package com.gotk.api

import House
import GoTkCharacter
import com.gotk.models.Book
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GoTkAPIService {
    @GET("characters/{character_id}")
    suspend fun getCharacterById(@Path("character_id") id: Int) : GoTkCharacter

    @GET("characters")
    suspend fun getCharacterByName(@Query("name") name: String) : List<GoTkCharacter>

    /*
    * Max. 214 pages
    */
    @GET("characters")
    suspend fun getCharactersByPage(@Query("page") num: Int) : List<GoTkCharacter>

    @GET
    suspend fun getCharacterByUrl(@Url url : String) : GoTkCharacter

    @GET("books/{book_id}")
    suspend fun getBookById(@Path("book_id") id: Int) : Book

    @GET
    suspend fun getBookByUrl(@Url url : String) : Book

    @GET("houses/{house_id}")
    suspend fun getHouseById(@Path("house_id") id: Int) : House

    @GET
    suspend fun getHouseByUrl(@Url url : String) : House


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