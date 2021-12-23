package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.otosales.apps.databinding.ActivityPaymentSuccessBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class PaymentSuccessActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPaymentSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityPaymentSuccessBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        this.setContentView(this.binding.root)

        this.binding.apply {

            FontHelper.Lexend.semiBold(this@PaymentSuccessActivity, this.textTitle)
            FontHelper.Lexend.medium(this@PaymentSuccessActivity, this.textTransactionId, this.textApprovedDateValue, this.textProcessedByValue, this.buttonFinish, this.buttonReportProblem)
            FontHelper.Lexend.regular(this@PaymentSuccessActivity, this.textTitleTransactionId, this.textApprovedDateTitle, this.textProcessedByTitle)

            GeneralHelper.makeClickable(this@PaymentSuccessActivity, this.buttonFinish, this.buttonReportProblem)
        }
    }

    override fun onClick(v: View?) {
        if (v == this.binding.buttonFinish){
            GeneralHelper.move(this, HomeActivity::class.java, true)
        }else if (v == this.binding.buttonReportProblem){
            GeneralHelper.move(this, DetailProblemActivity::class.java, true)
        }
    }
}