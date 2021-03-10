package com.example.androidstudy.scenes.searchresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudy.databinding.ItemSearchResultBinding
import com.example.androidstudy.repositories.qiita.entities.Article

class SearchResultAdapter(
    private val onArticleClickListener: (Article) -> Unit
): PagingDataAdapter<Article, SearchResultAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
) {
    class ViewHolder(private val binding: ItemSearchResultBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.titleText.text = article.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemSearchResultBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = getItem(position)
        article?.let {
            holder.bind(article)
            holder.itemView.setOnClickListener { onArticleClickListener(article) }
        }
    }
}