package com.example.androidstudy.repositories.qiita

import com.example.androidstudy.repositories.qiita.entities.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaAPI {
    @GET("items")
    suspend fun searchArticles(
        @Query("query") query: String? = null
    ): Response<List<Article>>
}