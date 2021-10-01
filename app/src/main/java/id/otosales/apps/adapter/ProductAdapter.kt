package id.otosales.apps.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.activity.DetailActivity
import id.otosales.apps.databinding.ItemProductBinding
import id.otosales.apps.dummy.product.Product
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class ProductAdapter(var activity : AppCompatActivity, private var products : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private lateinit var textTitle : TextView
        private lateinit var textPrice : TextView

        private lateinit var binding : ItemProductBinding

        @SuppressLint("SetTextI18n")
        fun bind(activity: AppCompatActivity, product: Product, position: Int) {
            this.binding = ItemProductBinding.bind(this.itemView)
            this.textTitle = this.binding.textTitle
            this.textPrice = this.binding.textPrice

            this.textTitle.text = product.name
            this.textPrice.text = activity.getString(R.string.rupiah_code) + GeneralHelper.currency(product.price!!)

            FontHelper.Lexend.medium(activity, this.textPrice)
            FontHelper.Lexend.regular(activity, this.textTitle)

            itemView.setOnClickListener {
                GeneralHelper.move(activity, DetailActivity::class.java, false)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = this.products[position]

        holder.bind(activity, product, position)
    }

    override fun getItemCount(): Int {
        return this.products.size
    }

}