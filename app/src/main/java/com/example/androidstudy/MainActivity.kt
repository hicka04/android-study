package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidstudy.repositories.qiita.QiitaAPI
import com.example.androidstudy.repositories.qiita.QiitaDataStore
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val contentType = MediaType.get("application/json")
            val qiitaAPI = Retrofit.Builder()
                .baseUrl("https://qiita.com/api/v2/")
                .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(contentType))
                .build()
                .create(QiitaAPI::class.java)
            val response = QiitaDataStore(qiitaAPI).searchArticles("kotlin")
            Log.d("MainActivity", response.toString())
        }
    }
}