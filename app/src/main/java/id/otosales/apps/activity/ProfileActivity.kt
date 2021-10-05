package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import id.otosales.apps.databinding.ActivityProfileBinding
import id.otosales.apps.helper.FontHelper

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    private lateinit var textName : TextView
    private lateinit var textPhone : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityProfileBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init(){
        this.textName = this.binding.textName
        this.textPhone = this.binding.textPhone

        FontHelper.Lexend.medium(this, this.textName)
        FontHelper.Lexend.regular(this, this.textPhone)
    }
}