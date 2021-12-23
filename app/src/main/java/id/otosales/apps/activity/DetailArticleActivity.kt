package id.otosales.apps.activity

import android.accounts.AuthenticatorDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import id.otosales.apps.Constant
import id.otosales.apps.api.model.article.ArticleResponseData
import id.otosales.apps.databinding.ActivityDetailArticleBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class DetailArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArticleBinding

    private lateinit var textTitle : TextView
    private lateinit var textPublisher : TextView
    private lateinit var textDate : TextView
    private lateinit var textDescription : TextView

    private lateinit var article: ArticleResponseData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailArticleBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.extract()
        this.init()
    }

    private fun extract() {
        val bundle = this.intent.getBundleExtra(Constant.Key.BUNDLING)
        this.article = bundle!!.getSerializable(Constant.Key.ARTICLE) as ArticleResponseData
    }

    private fun init() {
        this.textTitle = this.binding.textTitle
        this.textDate = this.binding.textDate
        this.textPublisher = this.binding.textPublisher
        this.textDescription = this.binding.textDesc

        this.textTitle.text = article.title
        this.textDescription.text = article.content
        this.textPublisher.text = article.creator
        this.textDate.text = article.created

        GeneralHelper.back(this, this.binding.imageBack)

        FontHelper.Lexend.semiBold(this, this.textTitle)
        FontHelper.Lexend.regular(this, this.textDate, this.textPublisher, this.textDescription)
    }
}