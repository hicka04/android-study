package com.example.androidstudy.scenes.searchresult

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudy.R
import com.example.androidstudy.databinding.FragmentSearchResultBinding
import com.example.androidstudy.scenes.detail.DetailFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment: Fragment(R.layout.fragment_search_result) {
    private val viewModel: SearchResultViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSearchResultBinding.bind(view)

        val searchResultAdapter = SearchResultAdapter(viewModel.articles, this) { article ->
            val action = SearchResultFragmentDirections.actionSearchResultFragmentToDetailFragment(article)
            findNavController().navigate(action)
        }
        binding.searchResultList.adapter = searchResultAdapter
        binding.searchResultList.layoutManager = LinearLayoutManager(context)

        viewModel.onViewCreated()
    }
}