package com.example.androidstudy.repositories.qiita.entities

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: String,
    val title: String,
    val url: String,
    val user: User
): java.io.Serializable
