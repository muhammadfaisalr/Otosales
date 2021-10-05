package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import id.otosales.apps.databinding.ActivityOrderSummaryBinding
import id.otosales.apps.helper.FontHelper

class OrderSummaryActivity : AppCompatActivity() {

    private lateinit var textType : TextView
    private lateinit var textPrice : TextView
    private lateinit var textIdTransaction : TextView

    private lateinit var binding : ActivityOrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityOrderSummaryBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init(){
        this.textType = this.binding.textType
        this.textPrice = this.binding.textPrice
        this.textIdTransaction = this.binding.textTransactionId

        FontHelper.Lexend.semiBold(this, this.binding.textTitle)
        FontHelper.Lexend.medium(this, this.binding.textTransactionId)
        FontHelper.Lexend.regular(this, this.textType, this.textPrice, this.binding.textTitleType)
    }
}