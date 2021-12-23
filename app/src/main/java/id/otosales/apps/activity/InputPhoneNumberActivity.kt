package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import id.otosales.apps.Constant
import id.otosales.apps.R
import id.otosales.apps.databinding.ActivityInputPhoneNumberBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class InputPhoneNumberActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityInputPhoneNumberBinding

    private lateinit var textTitle: TextView
    private lateinit var textSubtitle: TextView
    private lateinit var textCountryCode: TextView

    private lateinit var buttonNext: MaterialButton

    private lateinit var inputPhoneNumber: TextInputEditText

    private lateinit var imageBack: ImageView

    private lateinit var mode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityInputPhoneNumberBinding.inflate(this.layoutInflater)
        this.supportActionBar!!.hide()
        super.setContentView(this.binding.root)

        this.extract()
        this.init()
    }

    private fun extract() {
        val bundle = GeneralHelper.getBundlingBefore(this)

        if (bundle != null){
            this.mode = bundle.getString(Constant.Key.MODE, "")
        }
    }

    private fun init() {
        this.textTitle = this.binding.textTitle
        this.textSubtitle = this.binding.textSubtitle
        this.textCountryCode = this.binding.textCountryCode
        this.inputPhoneNumber = this.binding.inputPhoneNumber
        this.buttonNext = this.binding.buttonNext
        this.imageBack = this.binding.imageBack


        FontHelper.Lexend.semiBold(this, this.textTitle, this.textCountryCode)
        FontHelper.Lexend.medium(this, this.textSubtitle, this.inputPhoneNumber)
        FontHelper.Lexend.regular(this, this.buttonNext)

        this.buttonNext.setOnClickListener(this)
        this.imageBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == this.buttonNext) {
            this.next()
        } else if (v == this.imageBack) {
            this.finish()
        }
    }

    private fun next() {
        if (!this.inputPhoneNumber.text.isNullOrEmpty()) {
            this.validate()

            this.processToSendOtp()
        }
    }

    private fun processToSendOtp() {
        //Fungsi untuk proses send kode OTP dari Firebase

        val phone = this.inputPhoneNumber.text.toString()

        val bundle = Bundle()
        bundle.putString(Constant.Key.PHONE, phone)
        bundle.putString(Constant.Key.MODE, this.mode)

        GeneralHelper.move(
            this,
            OtpActivity::class.java,
            bundle,
            false
        )
    }

    private fun validate() {
        val length = this.inputPhoneNumber.text!!.length

        if (length < 10 || length > 13) {
            //throw Error, Karena Panjang Nomor Handphone Tidak Sesuai
            this.inputPhoneNumber.error = "Nomor Handphone tidak Valid. Silahkan Cek Kembali!"
            return
        }
    }
}