package id.otosales.apps.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.interfaces.OnTenorClick
import id.otosales.apps.databinding.ItemTenorBinding
import id.otosales.apps.dummy.Dummy
import id.otosales.apps.helper.FontHelper

class TenorAdapter(var activity : Activity, var callback : OnTenorClick) : RecyclerView.Adapter<TenorAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(activity: Activity, callback: OnTenorClick, position: Int) {
            this.binding = ItemTenorBinding.bind(this.itemView)
            this.binding.textTenor.text = Dummy.tenor()[position] + " Tahun"

            FontHelper.Lexend.regular(activity, this.binding.textTenor)

            this.itemView.setOnClickListener{
                callback.OnItemInRecyclerClicked(Dummy.tenor()[position], this.itemView)
            }
        }

        private lateinit var binding: ItemTenorBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tenor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.activity, callback, position)
    }

    override fun getItemCount(): Int {
        return Dummy.tenor().size
    }
}