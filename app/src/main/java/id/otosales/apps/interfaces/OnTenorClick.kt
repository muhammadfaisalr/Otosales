package id.otosales.apps.interfaces

import android.view.View

interface OnTenorClick : View.OnClickListener {
    fun OnItemInRecyclerClicked(value : String, view : View)
}