package com.example.androidstudy.repositories.qiita

import com.example.androidstudy.repositories.qiita.entities.Article
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface QiitaRepository {
    suspend fun searchArticles(keyword: String? = null): List<Article>
}

class QiitaDataStore @Inject constructor(private val qiitaAPI: QiitaAPI): QiitaRepository {
    override suspend fun searchArticles(keyword: String?): List<Article> {
        return qiitaAPI.searchArticles(keyword).body() ?: listOf()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class QiitaRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindQiitaRepository(
        qiitaDataStore: QiitaDataStore
    ): QiitaRepository
}