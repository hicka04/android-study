package com.example.androidstudy.repositories.qiita.entities

data class Article(
    val id: String,
    val title: String,
    val url: String,
    val user: User
)
