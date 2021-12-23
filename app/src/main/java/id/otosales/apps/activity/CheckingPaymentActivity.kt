package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import id.otosales.apps.databinding.ActivityCheckingPaymentBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class CheckingPaymentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCheckingPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityCheckingPaymentBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.binding.apply {
            FontHelper.Lexend.medium(this@CheckingPaymentActivity, this.textQ1, this.textQ2)
            FontHelper.Lexend.regular(this@CheckingPaymentActivity, this.textA1, this.textA2)
            FontHelper.Lexend.semiBold(this@CheckingPaymentActivity, this.textTitle)

            GeneralHelper.makeClickable(this@CheckingPaymentActivity, this.buttonUnderstood)
        }

        Handler(Looper.myLooper()!!).postDelayed({
            GeneralHelper.move(this, PaymentFailedActivity::class.java, true)
        }, 3000L)
    }

    override fun onClick(v: View?) {
        if (v == this.binding.buttonUnderstood){
            GeneralHelper.move(this, PaymentSuccessActivity::class.java, true)
        }
    }
}