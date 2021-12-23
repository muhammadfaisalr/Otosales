package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.otosales.apps.R
import id.otosales.apps.databinding.ActivityDetailProblemBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class DetailProblemActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailProblemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailProblemBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.binding.apply {

            FontHelper.Lexend.semiBold(this@DetailProblemActivity, this.textTitle)
            FontHelper.Lexend.medium(this@DetailProblemActivity, this.textTicketNo, textCloseProblem)
            FontHelper.Lexend.regular(this@DetailProblemActivity, this.inputMessage)

            GeneralHelper.makeClickable(this@DetailProblemActivity, this.imageBack, this.fabSendMessage, this.textCloseProblem)
        }
    }

    override fun onClick(v: View?) {
        if (v == this.binding.imageBack){
            finish()
        }
    }
}