package id.otosales.apps.helper

import android.app.Activity
import android.graphics.Typeface
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class FontHelper {
    companion object{
        const val lexendRegularPath = "font/Lexend_Regular.ttf"
        const val lexendMediumPath = "font/Lexend_Medium.ttf"
        const val lexendSemiBoldPath = "font/Lexend_SemiBold.ttf"
    }
    class Lexend {

        companion object{

            fun regular(activity : Activity, vararg views : Any?){
                for (view in views){
                    when (view) {
                        is TextView -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendRegularPath)
                        }
                        is TextInputEditText -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendRegularPath)
                        }
                        is MaterialButton -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendRegularPath)
                        }
                    }
                }
            }

            fun medium(activity : Activity, vararg views : Any?){
                for (view in views){
                    when (view) {
                        is TextView -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendMediumPath)
                        }
                        is TextInputEditText -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendMediumPath)
                        }
                        is MaterialButton -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendMediumPath)
                        }
                    }
                }
            }

            fun semiBold(activity : Activity, vararg views : Any?){
                for (view in views){
                    when (view) {
                        is TextView -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendSemiBoldPath)
                        }
                        is TextInputEditText -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendSemiBoldPath)
                        }
                        is MaterialButton -> {
                            view.typeface = Typeface.createFromAsset(activity.assets, FontHelper.lexendSemiBoldPath)
                        }
                    }
                }
            }
        }
    }
}