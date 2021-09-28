package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.otosales.apps.R
import id.otosales.apps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailBinding.inflate(this.layoutInflater)
        super.setContentView(this.binding.root)

        this.init()
    }

    private fun init(){

    }
}