package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.otosales.apps.databinding.ActivityFavoriteBinding
import id.otosales.apps.databinding.ViewEmptyBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class FavoriteActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityFavoriteBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.binding.apply {
            val emptyBinding = ViewEmptyBinding.bind(this.layoutEmpty.layoutParent)

            emptyBinding.buttonAction.setOnClickListener {
                GeneralHelper.move(this@FavoriteActivity, HomeActivity::class.java, false)
            }

            FontHelper.Lexend.semiBold(this@FavoriteActivity, this.textTitle)
            FontHelper.Lexend.medium(this@FavoriteActivity, emptyBinding.buttonAction, emptyBinding.textTitle)

            GeneralHelper.makeClickable(this@FavoriteActivity, this.imageBack)
        }
    }

    override fun onClick(v: View?) {
        if (v == this.binding.imageBack){
            finish()
        }
    }
}