package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.otosales.apps.databinding.ActivitySplashScreenBinding
import id.otosales.apps.helper.FirebaseHelper
import id.otosales.apps.helper.GeneralHelper

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        this.binding = ActivitySplashScreenBinding.inflate(this.layoutInflater)
        super.setContentView(this.binding.root)

        Handler(Looper.myLooper()!!).postDelayed({
            this.check()
        }, 3000L)
    }


    private fun check() {
        //Jika user sudah pernah login, maka langsung masuk kedalam home
        if (FirebaseHelper.getCurrentUser() != null){
            GeneralHelper.move(this, HomeActivity::class.java, true)
        }else{
            GeneralHelper.move(this, WelcomeActivity::class.java, true)
        }
    }
}