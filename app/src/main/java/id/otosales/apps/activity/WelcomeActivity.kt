package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import id.otosales.apps.Constant
import id.otosales.apps.databinding.ActivityWelcomeBinding
import id.otosales.apps.helper.FirebaseHelper
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper


class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWelcomeBinding

    private lateinit var textSlogan: MaterialTextView
    private lateinit var textSignIn: MaterialTextView

    private lateinit var buttonSignUp: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityWelcomeBinding.inflate(this.layoutInflater)
        this.supportActionBar!!.hide()
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init() {
        this.textSlogan = this.binding.textSlogan
        this.textSignIn = this.binding.textSignIn
        this.buttonSignUp = this.binding.buttonSignUp

        FontHelper.Lexend.semiBold(this, this.textSlogan)
        FontHelper.Lexend.medium(this, this.textSignIn, this.buttonSignUp)


        this.buttonSignUp.setOnClickListener(this)
        this.textSignIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == this.buttonSignUp) {
            GeneralHelper.move(
                this,
                InputPhoneNumberActivity::class.java,
                false,
                Constant.Key.MODE,
                Constant.Mode.SIGN_UP
            )
        } else {
            GeneralHelper.move(
                this,
                InputPhoneNumberActivity::class.java,
                false,
                Constant.Key.MODE,
                Constant.Mode.SIGN_IN
            )
        }
    }
}