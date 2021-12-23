package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import id.otosales.apps.databinding.ActivityProfileBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityProfileBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init() {
        this.binding.apply {

            FontHelper.Lexend.medium(this@ProfileActivity, this.textName, this.textStatus)
            FontHelper.Lexend.semiBold(this@ProfileActivity, this.textTitle)

            FontHelper.Lexend.regular(
                this@ProfileActivity,
                this.textPhone,
                this.textEditAccount,
                this.textFavorite,
                this.textCreditSimulation,
                this.textHelpCenter,
                this.textTos,
                this.textTermsAndCondition,
                this.textPrivacyPolicy,
                this.textLogout,
                this.textVersion
            )

            GeneralHelper.makeClickable(this@ProfileActivity, this.textFavorite)
        }

    }

    override fun onClick(v: View?) {
        if (v == this.binding.textFavorite){
            GeneralHelper.move(this, FavoriteActivity::class.java, false)
        }
    }
}