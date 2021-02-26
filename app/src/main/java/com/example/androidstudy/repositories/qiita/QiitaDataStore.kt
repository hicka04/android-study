package com.example.androidstudy.repositories.qiita

import com.example.androidstudy.repositories.qiita.entities.Article

interface QiitaRepository {
    suspend fun searchArticles(keyword: String? = null): List<Article>
}

class QiitaDataStore(private val qiitaAPI: QiitaAPI): QiitaRepository {
    override suspend fun searchArticles(keyword: String?): List<Article> {
        return qiitaAPI.searchArticles(keyword).body() ?: listOf()
    }
}