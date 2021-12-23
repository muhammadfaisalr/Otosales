package id.otosales.apps.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.databinding.ItemDiscussChildBinding
import id.otosales.apps.helper.FontHelper

class DiscussChildAdapter(var activity: Activity) : RecyclerView.Adapter<DiscussChildAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private var binding = ItemDiscussChildBinding.bind(itemView)

        fun bind(activity: Activity, position: Int) {
            FontHelper.Lexend.medium(activity, this.binding.textInitial, this.binding.textName)
            FontHelper.Lexend.regular(activity, this.binding.textContent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_discuss_child, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(activity, position)
    }

    override fun getItemCount(): Int {
        return 4
    }
}