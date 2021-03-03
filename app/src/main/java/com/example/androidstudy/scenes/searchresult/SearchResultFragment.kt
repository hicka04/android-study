package com.example.androidstudy.scenes.searchresult

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudy.R
import com.example.androidstudy.databinding.SearchResultFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment: Fragment(R.layout.search_result_fragment) {
    private val viewModel: SearchResultViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = SearchResultFragmentBinding.bind(view)

        val searchResultAdapter = SearchResultAdapter(viewModel.articles, this) { article ->
            Log.d("SearchResultFragment",article.title)
        }
        binding.searchResultList.adapter = searchResultAdapter
        binding.searchResultList.layoutManager = LinearLayoutManager(context)

        viewModel.onViewCreated()
    }
}