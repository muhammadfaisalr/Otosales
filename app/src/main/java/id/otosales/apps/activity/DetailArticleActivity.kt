package id.otosales.apps.activity

import android.accounts.AuthenticatorDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import id.otosales.apps.databinding.ActivityDetailArticleBinding
import id.otosales.apps.helper.FontHelper

class DetailArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArticleBinding

    private lateinit var textTitle : TextView
    private lateinit var textPublisher : TextView
    private lateinit var textDate : TextView
    private lateinit var textDescription : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailArticleBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init() {
        this.textTitle = this.binding.textTitle
        this.textDate = this.binding.textDate
        this.textPublisher = this.binding.textPublisher
        this.textDescription = this.binding.textDesc

        FontHelper.Lexend.semiBold(this, this.textTitle)
        FontHelper.Lexend.regular(this, this.textDate, this.textPublisher, this.textDescription)
    }
}