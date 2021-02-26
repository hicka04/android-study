package com.example.androidstudy.scenes.searchresult

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudy.repositories.qiita.QiitaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val qiitaRepository: QiitaRepository
): ViewModel() {
    fun onViewCreated() {
        viewModelScope.launch {
            val response = qiitaRepository.searchArticles("kotlin")
            Log.d("SearchResultViewModel", response.toString())
        }
    }
}