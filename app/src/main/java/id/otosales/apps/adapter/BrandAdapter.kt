package id.otosales.apps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.api.model.brand.BrandResponseDetail
import id.otosales.apps.databinding.ItemBrandBinding
import id.otosales.apps.helper.FontHelper

class BrandAdapter(var context: Context, var brands: ArrayList<BrandResponseDetail>) :
    RecyclerView.Adapter<BrandAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var binding = ItemBrandBinding.bind(itemView)

        fun bind(context: Context, brandResponseDetail: BrandResponseDetail) {
            context as AppCompatActivity
            binding.textBrandName.text = brandResponseDetail.name

            FontHelper.Lexend.medium(context, binding.textBrandName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_brand, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, brands[position])
    }

    override fun getItemCount(): Int {
        return brands.size
    }
}