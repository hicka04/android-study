package com.example.androidstudy.scenes.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.androidstudy.R
import com.example.androidstudy.databinding.FragmentDetailBinding

class DetailFragment: Fragment(R.layout.fragment_detail) {
    val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)
        binding.titleText.text = args.article.title
    }
}