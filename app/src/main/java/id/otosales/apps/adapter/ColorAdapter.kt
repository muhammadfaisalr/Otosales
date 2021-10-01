package id.otosales.apps.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.databinding.ItemColorBinding
import id.otosales.apps.dummy.product.color.Color

class ColorAdapter(var activity: Activity, var colors: ArrayList<Color>, var cardView: CardView) :
    RecyclerView.Adapter<ColorAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var cardView: CardView
        private lateinit var binding: ItemColorBinding

        @SuppressLint("ResourceType")
        fun bind(color: Color, cardView: CardView) {
            this.binding = ItemColorBinding.bind(this.itemView)
            this.cardView = this.binding.cardView
            this.cardView.setCardBackgroundColor(android.graphics.Color.parseColor(color.hex))
            this.cardView.radius = 8F

            this.itemView.setOnClickListener {
                cardView.setCardBackgroundColor(android.graphics.Color.parseColor(color.hex))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color = colors[position]

        holder.bind(color, this.cardView)
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}