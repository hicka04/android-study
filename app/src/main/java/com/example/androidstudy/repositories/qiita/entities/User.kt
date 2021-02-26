package com.example.androidstudy.repositories.qiita.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    @SerialName("profile_image_url")
    val profileImageUrl: String
)
