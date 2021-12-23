package id.otosales.apps.bottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.otosales.apps.R
import id.otosales.apps.adapter.DiscussAdapter
import id.otosales.apps.databinding.FragmentDiscussBottomSheetDialogBinding
import id.otosales.apps.helper.FontHelper

class DiscussBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentDiscussBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentDiscussBottomSheetDialogBinding.inflate(this.layoutInflater)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.init()
        this.setup()
    }

    private fun setup() {
        this.binding.recyclerDiscuss.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = DiscussAdapter(requireActivity())
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
    }

    private fun init() {
        FontHelper.Lexend.regular(requireActivity(), this.binding.inputWrite)
        FontHelper.Lexend.medium(requireActivity(), this.binding.textDiscuss)
    }
}