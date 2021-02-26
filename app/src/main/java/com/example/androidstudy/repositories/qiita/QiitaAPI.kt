package com.example.androidstudy.repositories.qiita

import com.example.androidstudy.repositories.qiita.entities.Article
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaAPI {
    @GET("items")
    suspend fun searchArticles(
        @Query("query") query: String? = null
    ): Response<List<Article>>
}

@Module
@InstallIn(ActivityComponent::class)
object QiitaAPIModule {
    @Provides
    fun provideQiitaAPI(): QiitaAPI {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl("https://qiita.com/api/v2/")
            .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(contentType))
            .build()
            .create(QiitaAPI::class.java)
    }
}