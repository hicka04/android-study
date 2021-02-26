package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidstudy.repositories.qiita.QiitaRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var qiitaRepository: QiitaRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}