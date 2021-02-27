package com.example.androidstudy.scenes.searchresult

import androidx.lifecycle.*
import com.example.androidstudy.repositories.qiita.QiitaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val qiitaRepository: QiitaRepository
): ViewModel() {
    private val _keyword = MutableLiveData<String>()
    val articles = liveData(viewModelScope.coroutineContext) {
        qiitaRepository.searchArticles(_keyword.value)
            .collect { emit(it) }
    }

    fun onViewCreated() {
        _keyword.postValue("kotlin")
    }
}