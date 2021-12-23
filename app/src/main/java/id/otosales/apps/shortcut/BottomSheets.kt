package id.otosales.apps.shortcut

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.otosales.apps.bottomsheet.BankBottomSheetDialogFragment
import id.otosales.apps.bottomsheet.DiscussBottomSheetDialogFragment
import id.otosales.apps.bottomsheet.OptionBottomSheetDialogFragment
import id.otosales.apps.bottomsheet.SelectCityBottomSheetDialogFragment
import id.otosales.apps.dummy.bank.Bank

class BottomSheets {
    companion object{
        private fun open(appCompatActivity: AppCompatActivity, bottomSheet: BottomSheetDialogFragment){
            bottomSheet.show(appCompatActivity.supportFragmentManager, BottomSheets::class.java.simpleName)
        }

        fun selectLocation(activity : AppCompatActivity){
            val bottomSheet = SelectCityBottomSheetDialogFragment()
            open(activity, bottomSheet)
        }

        fun discuss(activity: AppCompatActivity, isCancelable : Boolean){
            val bottomSheet = DiscussBottomSheetDialogFragment()
            bottomSheet.isCancelable = isCancelable

            open(activity, bottomSheet)
        }

        fun bank(activity: AppCompatActivity, banks: ArrayList<Bank>, isCancelable: Boolean){
            val bottomSheet = BankBottomSheetDialogFragment(banks)
            bottomSheet.isCancelable = isCancelable

            open(activity, bottomSheet)
        }

        fun option(activity: AppCompatActivity, title: String, description: String, negativeText: String?, positiveText: String, negativeListener: View.OnClickListener?, positiveListener: View.OnClickListener, isCancelable: Boolean){
            val bottomSheet = OptionBottomSheetDialogFragment(title, description, negativeText, positiveText, negativeListener, positiveListener)
            bottomSheet.isCancelable = isCancelable

            open(activity, bottomSheet)
        }
    }
}