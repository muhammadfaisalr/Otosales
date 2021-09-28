package id.otosales.apps.helper

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.view.View

class GeneralHelper {
    companion object {
        fun move(context: Context, dest: Class<*>, isForget: Boolean) {
            val intent = Intent(context, dest)

            if (isForget) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context.startActivity(intent)
                return
            }

            context.startActivity(intent)
        }

        fun move(context: Context, dest: Class<*>, isForget: Boolean, vararg bundle: Any) {
            //Bundle di separator dengan koma, untuk index yang ganjil maka dia key, index genap adalah value
            val intent = Intent(context, dest)

            if (isForget) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context.startActivity(intent)
                return
            }


            if (bundle.isNotEmpty()) {
                var indexOdd = 1

                var keys = arrayListOf<String>()
                var values = arrayListOf<String>()
                for (data in bundle) {
                    if (indexOdd % 2 != 0) {
                        keys.add(data.toString())
                    }

                    indexOdd += 1
                }

                var indexEven = 1
                for (data in bundle) {
                    if (indexEven % 2 == 0) {
                        values.add(data.toString())
                    }
                    indexEven += 1
                }

                /*Looping data Key nya,
                karena index dengan valuenya sama jadi yang diloop hanya key*/
                var index = 0
                for (data in keys) {
                    val value = values[index]

                    intent.putExtra(data, value)
                    index += 1
                }

            }

            context.startActivity(intent)
        }

        fun gone(vararg view : View){
            for (i in view){
                i.visibility = View.GONE
            }
        }

        fun visible(vararg view : View){
            for (i in view){
                i.visibility = View.VISIBLE
            }
        }
    }
}