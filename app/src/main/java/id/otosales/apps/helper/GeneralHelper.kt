package id.otosales.apps.helper

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.otosales.apps.Constant
import java.text.NumberFormat
import java.util.*

class GeneralHelper {
    companion object {
        fun move(context: Context, dest: Class<*>, isForget: Boolean) {
            val intent = Intent(context, dest)
            context.startActivity(intent)

            if (isForget){
                (context as AppCompatActivity).finish()
            }
        }

        fun move(context: Context, dest: Class<*>, bundle: Bundle, isForget: Boolean) {
            context.startActivity(Intent(context, dest).putExtra(Constant.Key.BUNDLING, bundle))

            if (isForget){
                (context as AppCompatActivity).finish()
            }
        }

        fun back(activity: AppCompatActivity, view: View){
            view.setOnClickListener {
                activity.finish()
            }
        }

        fun getBundlingBefore(activity: AppCompatActivity) : Bundle? {
            return activity.intent.getBundleExtra(Constant.Key.BUNDLING)
        }

        fun gone(vararg view: View) {
            for (i in view) {
                i.visibility = View.GONE
            }
        }

        fun visible(vararg view: View) {
            for (i in view) {
                i.visibility = View.VISIBLE
            }
        }

        fun currency(data: Long): String {
            return NumberFormat.getInstance(Locale("ID", "ID")).format(data)
        }

        fun makeClickable(listener: View.OnClickListener, vararg views: View){
            for(view in views){
                view.setOnClickListener(listener)
            }
        }

        fun getScreenHeight(): Int {
            return Resources.getSystem().displayMetrics.heightPixels
        }
    }
}