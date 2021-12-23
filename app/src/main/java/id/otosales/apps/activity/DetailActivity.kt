package id.otosales.apps.activity

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButtonToggleGroup
import id.otosales.apps.R
import id.otosales.apps.interfaces.OnTenorClick
import id.otosales.apps.adapter.TenorAdapter
import id.otosales.apps.databinding.ActivityDetailBinding
import id.otosales.apps.dummy.Dummy
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.shortcut.BottomSheets

class DetailActivity : AppCompatActivity(), View.OnClickListener,
    MaterialButtonToggleGroup.OnButtonCheckedListener, OnTenorClick {

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
    private lateinit var textDp : TextView

    private lateinit var spinnerType: AutoCompleteTextView
    private lateinit var spinnerLeasing: AutoCompleteTextView

    private lateinit var recyclerTenor: RecyclerView

    private lateinit var cardView: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailBinding.inflate(this.layoutInflater)
        this.supportActionBar!!.hide()
        super.setContentView(this.binding.root)

        this.init()
        this.setup()
        this.detect()
    }

    private fun detect() {
        if (this.binding.toggleTunai.isChecked) {
            GeneralHelper.gone(this.binding.layoutKredit)
        } else {
            GeneralHelper.visible(this.binding.layoutKredit)
        }
    }

    private fun setup() {
        this.recyclerTenor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        this.recyclerTenor.adapter = TenorAdapter(this, this)

        this.setupType()
    }

    private fun setupType() {
        val types = ArrayList<String>()
        for (i in Dummy.type()){
            types.add(i.name!!)
        }

        val arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, types)
        this.spinnerType.setAdapter(arrayAdapter)

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
        this.textDp = this.binding.textDp
        this.spinnerType = this.binding.spinnerType
        this.recyclerTenor = this.binding.recyclerTenor

        this.cardView = this.binding.cardView

        FontHelper.Lexend.semiBold(this, this.textPrice)

        FontHelper.Lexend.medium(
            this,
            this.textTitle,
            this.textTitleSpecification,
            this.binding.textTitleCreditSimulation,
            this.textDp,
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
            this.textType,
            this.textDescription,
            this.spinnerType,
            this.binding.textTitleDp,
            this.binding.textTitleCC,
            this.binding.textEngineTypeTitle,
            this.binding.textTitleMaxTorque,
            this.binding.textTitleTransmission,
            this.binding.textTitleType
        )

        this.binding.groupPayment.addOnButtonCheckedListener(this)

        GeneralHelper.makeClickable(this, this.binding.exfabBuy, this.textPrice, this.binding.linearDiscuss)
        GeneralHelper.back(this, this.binding.imageBack)
    }

    override fun OnItemInRecyclerClicked(value: String, view: View) {
        //Jika Item pada Recyclerview di klik.
        var index = 0
        for (v in Dummy.tenor()) {
            val card = this.recyclerTenor.layoutManager?.findViewByPosition(index)

            if (card is CardView) {
                card.setCardBackgroundColor(this.resources.getColor(R.color.browser_actions_bg_grey))

                var text = card.getChildAt(0)

                if (text is TextView) {
                    text.setTextColor(this.resources.getColor(R.color.inactive))
                }
            }

            index += 1
        }

        if (view is CardView) {
            view.setCardBackgroundColor(this.resources.getColor(R.color.blue_primary))

            var text = view.getChildAt(0)
            if (text is TextView) {
                text.setTextColor(this.resources.getColor(R.color.white))
            }
        }
    }

    override fun onClick(v: View?) {
        if (v == this.binding.exfabBuy) {
            this.buy()
        }else if (v == this.binding.linearDiscuss){
            BottomSheets.discuss(activity = this, isCancelable = true)
        }
    }

    private fun buy() {
        // TODO: 9/28/2021 Simpan Ke Google Room Data Transaksi nya
        GeneralHelper.move(this, OrderSummaryActivity::class.java, false)
    }


    private fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    override fun onButtonChecked(
        group: MaterialButtonToggleGroup?,
        checkedId: Int,
        isChecked: Boolean
    ) {
        this.detect()
    }
}