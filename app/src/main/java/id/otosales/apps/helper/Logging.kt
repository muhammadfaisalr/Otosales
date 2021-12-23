package id.otosales.apps.helper

import android.util.Log

class Logging {
    companion object{
        fun postD(clz: Class<*>, msg: String) {
            Log.d(clz.simpleName, msg)
        }

        fun postD(msg: String) {
            Log.d(Logging::class.java.simpleName, msg)
        }
    }
}