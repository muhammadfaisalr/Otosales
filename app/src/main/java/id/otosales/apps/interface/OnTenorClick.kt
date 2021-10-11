package id.otosales.apps.`interface`

import android.view.View

interface OnTenorClick : View.OnClickListener {
    fun OnClick(value : String, view : View)
}