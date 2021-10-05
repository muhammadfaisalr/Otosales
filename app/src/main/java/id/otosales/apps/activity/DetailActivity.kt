package id.otosales.apps.activity

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import id.otosales.apps.adapter.ColorAdapter
import id.otosales.apps.databinding.ActivityDetailBinding
import id.otosales.apps.databinding.BehaviorProductBinding
import id.otosales.apps.dummy.Dummy
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.shortcut.Animations

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailBinding

    private lateinit var textPrice: TextView
    private lateinit var textTitle: TextView
    private lateinit var textPurchased: TextView
    private lateinit var textTitleSpecification: TextView
    private lateinit var textCC: TextView
    private lateinit var textEngineType: TextView
    private lateinit var textMaxTorque: TextView
    private lateinit var textTransmission: TextView
    private lateinit var textType: TextView
    private lateinit var textDescription: TextView

    private lateinit var cardView: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailBinding.inflate(this.layoutInflater)
        this.supportActionBar!!.hide()
        super.setContentView(this.binding.root)

        this.init()

    }

    private fun init() {
        this.textPrice = this.binding.textPrice
        this.textTitle = this.binding.textTitle
        this.textPurchased = this.binding.textPurchased
        this.textTitleSpecification = this.binding.textTitleSpecification
        this.textCC = this.binding.textCC
        this.textEngineType = this.binding.textEngineType
        this.textMaxTorque = this.binding.textMaxTorque
        this.textTransmission = this.binding.textTransmission
        this.textType = this.binding.textType
        this.textDescription = this.binding.textDescription

        this.cardView = this.binding.cardView

        //Start Init for Behavior

        FontHelper.Lexend.medium(
            this,
            this.textTitle,
            this.textTitleSpecification,
            this.binding.textTitleCreditSimulation,
            this.binding.textTitleDiscuss,
            this.binding.textTitleReview,
            this.binding.textTitleDescription
        )

        FontHelper.Lexend.regular(
            this,
            this.textPurchased,
            this.textCC,
            this.textEngineType,
            this.textMaxTorque,
            this.textTransmission,
            this.binding.textTitleCC,
            this.textType,
            this.textDescription,
            this.binding.textEngineTypeTitle,
            this.binding.textTitleMaxTorque,
            this.binding.textTitleTransmission,
            this.binding.textTitleType
        )
        FontHelper.Lexend.semiBold(this, this.textPrice)

        this.binding.exfabBuy.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == this.binding.exfabBuy){
            this.buy()
        }
    }

    private fun buy() {
        // TODO: 9/28/2021 Simpan Ke Google Room Data Transaksi nya
        GeneralHelper.move(this, OrderSummaryActivity::class.java, false)
    }


    private fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }
}