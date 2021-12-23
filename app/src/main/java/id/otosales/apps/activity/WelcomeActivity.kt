package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import id.otosales.apps.Constant
import id.otosales.apps.R
import id.otosales.apps.databinding.ActivityWelcomeBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.shortcut.BottomSheets


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

        this.binding.apply {
            FontHelper.Lexend.semiBold(this@WelcomeActivity, this.textSlogan)
            FontHelper.Lexend.medium(this@WelcomeActivity, this.textSignIn, this.buttonSignUp, this.textSkip)

            GeneralHelper.makeClickable(this@WelcomeActivity, this.textSignIn, this.buttonSignUp, this.textSkip)
        }
    }

    override fun onClick(v: View?) = if (v == this.buttonSignUp) {
        val bundle = Bundle()
        bundle.putString(Constant.Key.MODE, Constant.Mode.SIGN_UP)

        GeneralHelper.move(
            this,
            InputPhoneNumberActivity::class.java,
            bundle,
            false
        )
    } else if(v == this.binding.textSkip){
        BottomSheets.option(
            this,
            getString(R.string.skip_process),
            getString(R.string.skip_login_description),
            getString(R.string.cancel),
            getString(R.string.continue_anyway),
            null,
            {
                GeneralHelper.move(this, HomeActivity::class.java, true)
            },
            true
        )
    } else {
        val bundle = Bundle()
        bundle.putString(Constant.Key.MODE, Constant.Mode.SIGN_IN)

        GeneralHelper.move(
            this,
            InputPhoneNumberActivity::class.java,
            bundle,
            false
        )
    }
}