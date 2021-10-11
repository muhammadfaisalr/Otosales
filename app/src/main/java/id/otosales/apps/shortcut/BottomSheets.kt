package id.otosales.apps.shortcut

import androidx.appcompat.app.AppCompatActivity
import id.otosales.apps.bottomsheet.SelectCityBottomSheetDialogFragment

class BottomSheets {
    companion object{
        fun selectLocation(activity : AppCompatActivity){
            val bottomSheet = SelectCityBottomSheetDialogFragment()
            bottomSheet.show(activity.supportFragmentManager, activity.javaClass.simpleName)
        }
    }
}