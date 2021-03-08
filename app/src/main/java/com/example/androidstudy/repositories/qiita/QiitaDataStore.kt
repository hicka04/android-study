package com.example.androidstudy.repositories.qiita

import com.example.androidstudy.repositories.qiita.entities.Article
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

interface QiitaRepository {
    fun searchArticles(keyword: String? = null): Flow<List<Article>>
}

class QiitaDataStore @Inject constructor(private val qiitaAPI: QiitaAPI): QiitaRepository {
    override fun searchArticles(keyword: String?): Flow<List<Article>> = flow {
        qiitaAPI.searchArticles(keyword).body()?.let {
            emit(it)
        }
    }.flowOn(Dispatchers.IO)
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