package id.otosales.apps.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.otosales.apps.adapter.BankAdapter
import id.otosales.apps.databinding.FragmentBankBottomSheetDialogBinding
import id.otosales.apps.dummy.bank.Bank
import id.otosales.apps.helper.FontHelper


class BankBottomSheetDialogFragment(var banks: ArrayList<Bank>) : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentBankBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentBankBottomSheetDialogBinding.inflate(this.layoutInflater)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.apply {
            this.recyclerBank.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            this.recyclerBank.adapter = BankAdapter(requireContext(), this@BankBottomSheetDialogFragment.banks)
            this.recyclerBank.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))

            FontHelper.Lexend.semiBold(requireActivity(), this.textTitle)
        }
    }
}