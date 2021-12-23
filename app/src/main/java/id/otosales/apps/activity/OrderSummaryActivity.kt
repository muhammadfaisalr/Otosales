package id.otosales.apps.activity

import  android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.View
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import id.otosales.apps.api.model.BaseResponse
import id.otosales.apps.api.model.bank.BankResponse
import id.otosales.apps.databinding.ActivityOrderSummaryBinding
import id.otosales.apps.dummy.bank.Bank
import id.otosales.apps.helper.ApiHelper
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.shortcut.BottomSheets
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class OrderSummaryActivity : AppCompatActivity() {

    private lateinit var textType: TextView
    private lateinit var textPrice: TextView
    private lateinit var textTenor: TextView
    private lateinit var textValueTenor: TextView
    private lateinit var textIdTransaction: TextView

    private lateinit var gestureDetector: GestureDetector

    private lateinit var binding: ActivityOrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityOrderSummaryBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
        this.bottomSheet()
    }

    private fun bottomSheet() {
        val bottomSheet = BottomSheetBehavior.from(this.binding.behavior.behavior)
        val behaviorBinding = this.binding.behavior
        val banks = ArrayList<Bank>()

        CompositeDisposable().add(
            ApiHelper
                .getBanks()
                .subscribeWith(object : DisposableObserver<Response<BankResponse>>() {
                    override fun onNext(t: Response<BankResponse>) {
                        if (t.body() != null) {
                            if (t.body()!!.data != null){
                                for (i in t.body()!!.data!!){
                                    banks.add(Bank(i.name, i.shortName, i.bankCode, i.accountNumber))
                                }
                            }
                        }
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {

                    }
                })
        )
        behaviorBinding.apply {
            this.buttonShow.setOnClickListener{
                BottomSheets.bank(this@OrderSummaryActivity, banks, true)
            }

            this.buttonConfirm.setOnClickListener{
                GeneralHelper.move(this@OrderSummaryActivity, CheckingPaymentActivity::class.java, false)
            }

            FontHelper.Lexend.medium(this@OrderSummaryActivity, this.textAccountNumber, this.textAmount)
            FontHelper.Lexend.regular(this@OrderSummaryActivity, this.textDescription, this.textSubtitle, this.textName)
            FontHelper.Lexend.semiBold(this@OrderSummaryActivity, this.textTitle)
        }

        bottomSheet.peekHeight = GeneralHelper.getScreenHeight() / 8
        bottomSheet.isDraggable = true
        bottomSheet.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED){
                    behaviorBinding.layoutAction.visibility = View.GONE
                    behaviorBinding.layoutChild.visibility = View.VISIBLE
                }else if (newState == BottomSheetBehavior.STATE_COLLAPSED){
                    behaviorBinding.layoutAction.visibility = View.VISIBLE
                    behaviorBinding.layoutChild.visibility = View.GONE
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun init() {
        this.textType = this.binding.textType
        this.textPrice = this.binding.textCash
        this.textIdTransaction = this.binding.textTransactionId

        FontHelper.Lexend.semiBold(this, this.binding.textTitle)

        FontHelper.Lexend.medium(this, this.binding.textTransactionId)

        FontHelper.Lexend.regular(
            activity = this,
            this.textType,
            this.textPrice,
            this.binding.textDescription,
            this.binding.buttonCancel,
            this.binding.buttonSave,
            this.binding.textTitleTransactionId,
            this.binding.textTitleType,
            this.binding.textTitleType2,
            this.binding.textTitleTenor,
            this.binding.textTitleTenor2,
            this.binding.textValueTenor,
            this.binding.textTenor
        )
    }
}