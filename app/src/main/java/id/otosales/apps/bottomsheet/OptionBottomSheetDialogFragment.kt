package id.otosales.apps.bottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.otosales.apps.R
import id.otosales.apps.databinding.FragmentOptionBottomSheetDialogBinding
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper

class OptionBottomSheetDialogFragment(
    var title: String,
    var description: String,
    var negativeButtonText: String?,
    var positiveButtonText: String?,
    var negativeButtonListener: View.OnClickListener?,
    var positiveButtonListener: View.OnClickListener,
) : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var binding: FragmentOptionBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentOptionBottomSheetDialogBinding.inflate(this.layoutInflater)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.binding.apply {
            if (negativeButtonText == null){
                this.buttonNegative.visibility = View.GONE
            }else{
                this.buttonNegative.text = negativeButtonText
            }

            this.textTitle.text = title
            this.textDescription.text = description
            this.buttonPositive.text = positiveButtonText

            FontHelper.Lexend.medium(requireActivity(), this.textTitle, this.buttonNegative, this.buttonPositive)
            FontHelper.Lexend.regular(requireActivity(), this.textDescription)

            GeneralHelper.makeClickable(positiveButtonListener, this.buttonPositive)

            if (negativeButtonListener == null){
                GeneralHelper.makeClickable(this@OptionBottomSheetDialogFragment, this.buttonNegative)
            }else{
                GeneralHelper.makeClickable(negativeButtonListener!!, this.buttonNegative)
            }
        }
    }

    override fun onClick(v: View?) {
        if (v == this.binding.buttonNegative){
            dismiss()
        }
    }
}