package id.otosales.apps.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import id.otosales.apps.Constant
import id.otosales.apps.R
import id.otosales.apps.databinding.ActivityOtpBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.helper.StringHelper
import id.otosales.apps.ui.Loading
import java.util.concurrent.TimeUnit

class OtpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityOtpBinding

    private lateinit var textTitle: TextView
    private lateinit var textSubtitle: TextView

    private lateinit var inputOtp: TextInputEditText

    private lateinit var buttonVerification: MaterialButton

    private lateinit var auth: FirebaseAuth

    private lateinit var storedOtpId: String
    private lateinit var mode: String

    private lateinit var phoneNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityOtpBinding.inflate(this.layoutInflater)
        this.supportActionBar!!.hide()
        super.setContentView(this.binding.root)

        this.extract()
        this.init()
        this.processSendOtp()
    }

    private fun extract() {
        //Dapatkan data yang dikirim dari activity sebelumnya
        val bundle = GeneralHelper.getBundlingBefore(this)

        if (bundle != null) {
            this.phoneNumber = bundle.getString(Constant.Key.PHONE, "")
            this.mode = bundle.getString(Constant.Key.MODE, "")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        this.textTitle = this.binding.textTitle
        this.textSubtitle = this.binding.textSubtitle
        this.inputOtp = this.binding.inputOtp
        this.buttonVerification = this.binding.buttonVerification

        this.auth = FirebaseAuth.getInstance()


        this.textSubtitle.text =
            this.getString(R.string.we_was_send_your_verification_code_to_number) + " " + this.getString(
                R.string.prefix_id_code
            ) + phoneNumber

        FontHelper.Lexend.semiBold(this, this.textTitle, this.inputOtp)
        FontHelper.Lexend.medium(this, this.textSubtitle)
        FontHelper.Lexend.regular(this, this.buttonVerification)

        this.buttonVerification.setOnClickListener(this)
    }

    private fun processSendOtp() {
        //Process Untuk Send OTP
        val phone = "+62${this.phoneNumber}"
        println("Send OTP Requested to Number : $phone for $mode")

        this.auth.setLanguageCode("id")

        val callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                Log.d(OtpActivity::class.simpleName, "Otp Delivered to : $phone")
                this@OtpActivity.storedOtpId = p0
            }

            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                this@OtpActivity.signInWithCredential(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException) {

            }

        }

        val options = PhoneAuthOptions.newBuilder(this.auth)
            .setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS) //Code invalid dalam 1 menit
            .setActivity(this@OtpActivity)
            .setCallbacks(callback)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun signInWithCredential(p0: PhoneAuthCredential) {

        val loading = Loading(this)
        loading.setCancelable(false)
        loading.show()

        this.auth.signInWithCredential(p0)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    loading.dismiss()
                    // TODO: 9/25/2021 Validasi ke Backend dlu.
                    if (StringHelper.isEqual(this.mode, Constant.Mode.SIGN_UP)) {
                        GeneralHelper.move(this@OtpActivity, SignUpActivity::class.java, GeneralHelper.getBundlingBefore(this)!!, false)
                    } else {
                        GeneralHelper.move(this@OtpActivity, HomeActivity::class.java, true)
                    }
                }
            }
    }

    override fun onClick(v: View?) {
        if (v == this.buttonVerification) {
            if (TextUtils.isEmpty(this.inputOtp.text)) {
                this.inputOtp.error = "Kode OTP Tidak Valid."
                return
            }
            this.next(this.inputOtp.text.toString())
        }
    }

    private fun next(code: String) {
        val credential = PhoneAuthProvider.getCredential(this.storedOtpId, code)

        this.signInWithCredential(credential)
    }
}