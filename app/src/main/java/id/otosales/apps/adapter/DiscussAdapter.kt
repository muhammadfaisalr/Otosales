package id.otosales.apps.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.databinding.ItemDiscussParentBinding
import id.otosales.apps.helper.FontHelper

class DiscussAdapter(var activity : Activity) : RecyclerView.Adapter<DiscussAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private var binding = ItemDiscussParentBinding.bind(this.itemView)

        fun bind(activity: Activity, position: Int) {
            FontHelper.Lexend.medium(activity, this.binding.textInitial, this.binding.textName, this.binding.textReply)
            FontHelper.Lexend.regular(activity, this.binding.textContent)

            if (position == 2){
                this.binding.recyclerReplies.apply {
                    layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                    adapter = DiscussChildAdapter(activity)
                    addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_discuss_parent, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.activity, position)
    }

    override fun getItemCount(): Int {
        return 5
    }
}