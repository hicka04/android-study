package com.example.androidstudy.scenes.searchresult

import androidx.lifecycle.*
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
        .flatMapLatest { qiitaRepository.searchArticles(it) }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    fun onViewCreated() {
        _keyword.value = "kotlin"
    }
}