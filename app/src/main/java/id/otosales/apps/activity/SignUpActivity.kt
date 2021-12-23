package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import id.otosales.apps.Constant
import id.otosales.apps.api.model.BaseResponse
import id.otosales.apps.api.model.register.RegisterRequest
import id.otosales.apps.databinding.ActivitySignUpBinding
import id.otosales.apps.helper.ApiHelper
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.helper.Logging
import id.otosales.apps.ui.Loading
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import retrofit2.Response

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

        this.extract()
        this.init()
    }

    private fun extract() {
        val bundle = GeneralHelper.getBundlingBefore(this)

        Logging.postD(bundle?.getString(Constant.Key.MODE, "Null")!!)
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
        val loading = Loading(this)
        loading.setCancelable(false)
        loading.show()

        if (v == this.buttonFinish){
            val registerRequest = RegisterRequest(phone = "6281287616776", name = "Muhammad Faisal", email = "muhammadfaisalr17@gmail.com")
            CompositeDisposable().add(
                ApiHelper
                    .hitRegister(registerRequest)
                    .subscribeWith(object : DisposableObserver<Response<BaseResponse>>() {
                        override fun onNext(t: Response<BaseResponse>) {
                            loading.dismiss()
                        }

                        override fun onError(e: Throwable) {
                            loading.dismiss()
                        }

                        override fun onComplete() {
                            loading.dismiss()
                            GeneralHelper.move(this@SignUpActivity, HomeActivity::class.java, true)
                        }
                    })
            )
        }
    }
}