package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.otosales.apps.databinding.ActivityChoosePaymentBinding

class ChoosePaymentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChoosePaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityChoosePaymentBinding.inflate(this.layoutInflater)
        super.setContentView(this.binding.root)
    }
}