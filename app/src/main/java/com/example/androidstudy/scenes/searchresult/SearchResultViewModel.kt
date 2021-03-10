package com.example.androidstudy.scenes.searchresult

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.androidstudy.repositories.qiita.QiitaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val qiitaRepository: QiitaRepository
): ViewModel() {
    private val _keyword = MutableStateFlow("")
    val articles = _keyword
        .flatMapLatest {
            Pager(
                PagingConfig(pageSize = 20)
            ) {
                SearchResultPagingSource(
                    qiitaRepository,
                    it
                )
            }.flow
        }.cachedIn(viewModelScope)

    fun onViewCreated() {
        _keyword.value = "kotlin"
    }
}