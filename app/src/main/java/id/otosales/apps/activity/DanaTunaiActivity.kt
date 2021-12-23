package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import id.otosales.apps.R
import id.otosales.apps.databinding.ActivityDanaTunaiBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class DanaTunaiActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDanaTunaiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDanaTunaiBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.binding.apply {

            FontHelper.Lexend.semiBold(this@DanaTunaiActivity, this.textTitle)
            FontHelper.Lexend.medium(
                this@DanaTunaiActivity,
                this.textDanaTunaiTitle,
                this.textSelectGuarantee,
                this.buttonRequestNow
            )
            FontHelper.Lexend.regular(
                this@DanaTunaiActivity,
                this.textDanaTunaiDesc,
                this.textCar,
                this.textBike,
                this.inputFullName,
                this.inputPhoneNumber,
                this.inputLocation,
                this.inputEmail,
                this.rbAtasNamaOrangLain,
                this.rbAtasNamaSendiri
            )

            GeneralHelper.makeClickable(this@DanaTunaiActivity, this.cardBike, this.cardCar)
        }
    }

    override fun onClick(v: View?) {
        if (v == this.binding.cardBike) {
            this.selectBike()
        } else if (v == this.binding.cardCar) {
            this.selectCar()
        }
    }

    private fun selectCar() {
        this.binding.apply {
            this.imageCar.setColorFilter(
                ContextCompat.getColor(
                    this@DanaTunaiActivity,
                    R.color.white
                ), android.graphics.PorterDuff.Mode.SRC_IN
            )
            this.imageBike.colorFilter = null
            this.textBike.setTextColor(
                ContextCompat.getColor(
                    this@DanaTunaiActivity,
                    R.color.black
                )
            )
            this.textCar.setTextColor(ContextCompat.getColor(this@DanaTunaiActivity, R.color.white))
            this.cardBike.setCardBackgroundColor(
                this@DanaTunaiActivity.resources.getColor(
                    R.color.white,
                    null
                )
            )
            this.cardCar.setCardBackgroundColor(
                this@DanaTunaiActivity.resources.getColor(
                    R.color.blue_primary,
                    null
                )
            )
        }
    }

    private fun selectBike() {
        this.binding.apply {
            this.imageCar.colorFilter = null
            this.imageBike.setColorFilter(
                ContextCompat.getColor(
                    this@DanaTunaiActivity,
                    R.color.white
                ), android.graphics.PorterDuff.Mode.SRC_IN
            )
            this.textBike.setTextColor(
                ContextCompat.getColor(
                    this@DanaTunaiActivity,
                    R.color.white
                )
            )
            this.textCar.setTextColor(ContextCompat.getColor(this@DanaTunaiActivity, R.color.black))
            this.cardBike.setCardBackgroundColor(
                this@DanaTunaiActivity.resources.getColor(
                    R.color.blue_primary,
                    null
                )
            )
            this.cardCar.setCardBackgroundColor(
                this@DanaTunaiActivity.resources.getColor(
                    R.color.white,
                    null
                )
            )
        }
    }
}