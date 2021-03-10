package com.example.androidstudy.scenes.searchresult

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.androidstudy.repositories.qiita.QiitaRepository
import com.example.androidstudy.repositories.qiita.entities.Article
import kotlinx.coroutines.flow.single

class SearchResultPagingSource(
    private val qiitaRepository: QiitaRepository,
    private val keyword: String
): PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val articles = qiitaRepository
                .searchArticles(keyword, page, params.loadSize)
                .single()
            LoadResult.Page(
                data = articles,
                prevKey = null,
                nextKey = page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition
    }
}