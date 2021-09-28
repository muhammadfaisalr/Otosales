package id.otosales.apps.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import id.otosales.apps.R
import id.otosales.apps.databinding.FragmentSelectCityBottomSheetDialogBinding
import id.otosales.apps.dummy.Dummy
import id.otosales.apps.helper.FontHelper


class SelectCityBottomSheetDialogFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var binding: FragmentSelectCityBottomSheetDialogBinding

    private lateinit var textTitle: TextView
    private lateinit var imageClose: ImageView

    private lateinit var inputProvince: AutoCompleteTextView
    private lateinit var inputCity: AutoCompleteTextView

    private lateinit var buttonSet: MaterialButton

    private var province: String = ""
    private var city: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = FragmentSelectCityBottomSheetDialogBinding.inflate(this.layoutInflater)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.init()
        this.setup()
    }

    private fun setup() {
        val provinceAdapter = ArrayAdapter(
            requireActivity(),
            R.layout.support_simple_spinner_dropdown_item,
            Dummy.province()
        )
        this.inputProvince.setAdapter(provinceAdapter)
        this.inputProvince.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                //Dapatkan nama provinsi berdasarkan index pada array yang di insert ke spinner
                var index = 0
                for (i in Dummy.province()) {
                    if (index == position) {
                        province = i
                        break
                    }
                    index += 1
                }
            }

        val cityAdapter = ArrayAdapter(
            requireActivity(),
            R.layout.support_simple_spinner_dropdown_item,
            Dummy.city()
        )
        this.inputCity.setAdapter(cityAdapter)
    }

    private fun init() {
        this.textTitle = this.binding.textTitle
        this.imageClose = this.binding.imageClose
        this.inputProvince = this.binding.inputProvince
        this.inputCity = this.binding.inputCity
        this.buttonSet = this.binding.buttonSet

        FontHelper.Lexend.medium(requireActivity(), this.textTitle)
        FontHelper.Lexend.regular(requireActivity(), this.inputProvince, this.inputCity)

        this.imageClose.setOnClickListener {
            dismiss()
        }

        this.buttonSet.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == this.buttonSet) {
            // TODO: 9/28/2021 Simpan Data Pengaturan Lokasi Kedalam Google Room (Database Lokal);
            Toast.makeText(requireActivity(), province, Toast.LENGTH_SHORT).show()
            this.dismiss()
        }
    }
}