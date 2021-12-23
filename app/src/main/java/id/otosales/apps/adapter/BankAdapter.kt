package id.otosales.apps.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.R
import id.otosales.apps.databinding.ItemBankBinding
import id.otosales.apps.dummy.bank.Bank
import id.otosales.apps.helper.FontHelper

class BankAdapter(var context: Context, var banks: ArrayList<Bank>) : RecyclerView.Adapter<BankAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var binding = ItemBankBinding.bind(v)

        fun bind(context: Context, bank: Bank) {
            this.binding.apply {
                this.textShortCode.text = bank.shortName
                this.textBankName.text = bank.name
                this.accountNumber.text = "[${bank.code}] ${bank.number}"

                context as Activity
                FontHelper.Lexend.semiBold(context, this.textShortCode)
                FontHelper.Lexend.medium(context, this.textBankName)
                FontHelper.Lexend.regular(context, this.accountNumber)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_bank, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bank = this.banks[position]
        holder.bind(context, bank)
    }

    override fun getItemCount(): Int {
        return this.banks.size
    }
}