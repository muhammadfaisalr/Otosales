package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import id.otosales.apps.databinding.ActivitySignUpBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivitySignUpBinding

    private lateinit var inputName : TextInputEditText

    private lateinit var textTitle : TextView
    private lateinit var textSubtitle : TextView

    private lateinit var buttonFinish : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivitySignUpBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init(){
        this.inputName = this.binding.inputName
        this.textTitle = this.binding.textTitle
        this.textSubtitle = this.binding.textSubtitle
        this.buttonFinish = this.binding.buttonFinish

        FontHelper.Lexend.regular(this, this.inputName, this.buttonFinish)
        FontHelper.Lexend.semiBold(this, this.textTitle)
        FontHelper.Lexend.medium(this, this.textSubtitle)

        this.buttonFinish.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == this.buttonFinish){
            GeneralHelper.move(this, HomeActivity::class.java, true)
        }
    }
}