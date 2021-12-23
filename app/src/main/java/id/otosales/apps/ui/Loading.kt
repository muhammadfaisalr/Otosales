package id.otosales.apps.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.otosales.apps.R
import id.otosales.apps.databinding.ItemLoadingBinding
import id.otosales.apps.helper.FontHelper

class Loading(context: Context) : AlertDialog(context)  {

    var binding = ItemLoadingBinding.bind(LayoutInflater.from(context).inflate(R.layout.item_loading, null))

    init {
        super.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.binding.apply {
            FontHelper.Lexend.medium((context as AppCompatActivity), this.textLoading)
        }
    }



    override fun show() {
        super.show()
        super.setContentView(R.layout.item_loading)
    }
}