package com.example.androidstudy.scenes.searchresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudy.databinding.ItemSearchResultBinding
import com.example.androidstudy.repositories.qiita.entities.Article

class SearchResultAdapter(
    private val articles: LiveData<List<Article>>,
    lifecycleOwner: LifecycleOwner,
    private val onArticleClickListener: (Article) -> Unit
): RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {
    init {
        articles.observe(lifecycleOwner) {
            notifyDataSetChanged()
        }
    }

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
        holder.bind(articles.value!![position])
        holder.itemView.setOnClickListener { onArticleClickListener(articles.value!![position]) }
    }

    override fun getItemCount(): Int {
        return articles.value?.size ?: 0
    }
}