package id.otosales.apps.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.activity.DetailArticleActivity
import id.otosales.apps.databinding.ItemArticleBinding
import id.otosales.apps.dummy.article.Article
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class ArticleAdapter(var activity: Activity, var articles : ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var binding : ItemArticleBinding

        fun bind(activity: Activity, article: Article) {
            this.binding = ItemArticleBinding.bind(this.itemView)

            this.binding.textTitle.text = article.title
            this.binding.textDesc.text = article.shortDescription

            FontHelper.Lexend.medium(activity, this.binding.textTitle, this.binding.textLike    )
            FontHelper.Lexend.regular(activity, this.binding.textDesc)

            this.itemView.setOnClickListener{
                GeneralHelper.move(activity, DetailArticleActivity::class.java, false)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(activity, this.articles[position])
    }

    override fun getItemCount(): Int {
        return this.articles.size
    }
}