package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import id.otosales.apps.databinding.ActivityListTransactionBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class ListTransactionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityListTransactionBinding

    private lateinit var textTitle : TextView

    private lateinit var buttonAddTransaction : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityListTransactionBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init(){
        this.textTitle = this.binding.textTitle
        this.buttonAddTransaction = this.binding.buttonAddTransaction

        FontHelper.Lexend.medium(this, this.textTitle)
        FontHelper.Lexend.regular(this, this.buttonAddTransaction)

        GeneralHelper.makeClickable(this, this.buttonAddTransaction)
    }

    override fun onClick(v: View?) {
        if (v == this.buttonAddTransaction){
            finish()
        }
    }
}