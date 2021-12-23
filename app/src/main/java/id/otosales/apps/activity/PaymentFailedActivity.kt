package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.otosales.apps.databinding.ActivityPaymentFailedBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class PaymentFailedActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPaymentFailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityPaymentFailedBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        this.setContentView(this.binding.root)

        this.binding.apply {

            FontHelper.Lexend.semiBold(this@PaymentFailedActivity, this.textTitle)
            FontHelper.Lexend.medium(this@PaymentFailedActivity, this.textTransactionId, this.textApprovedDateValue, this.textProcessedByValue, this.buttonFinish, this.buttonReportProblem)
            FontHelper.Lexend.regular(this@PaymentFailedActivity, this.textTitleTransactionId, this.textApprovedDateTitle, this.textProcessedByTitle)

            GeneralHelper.makeClickable(this@PaymentFailedActivity, this.buttonFinish, this.buttonReportProblem)
        }
    }

    override fun onClick(v: View?) {

    }
}