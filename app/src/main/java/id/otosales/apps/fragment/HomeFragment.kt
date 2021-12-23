package id.otosales.apps.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import id.otosales.apps.activity.DanaTunaiActivity
import id.otosales.apps.adapter.ProductAdapter
import id.otosales.apps.databinding.FragmentHomeBinding
import id.otosales.apps.dummy.Dummy
import id.otosales.apps.shortcut.BottomSheets
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper


class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var activity: AppCompatActivity

    private lateinit var textQuantityProduct: TextView
    private lateinit var textSort: TextView
    private lateinit var textLocation: TextView

    private lateinit var cardLocation: CardView

    private lateinit var imageSearch: ImageView
    private lateinit var imageClose: ImageView

    private lateinit var recyclerProduct: RecyclerView

    private lateinit var inputSearch: TextInputEditText
    private lateinit var inputLayoutSearch: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = FragmentHomeBinding.inflate(layoutInflater)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.init()
        this.setup()
    }

    private fun setup() {
        // Konfigurasi Untuk Recyler View
        this.recyclerProduct.isNestedScrollingEnabled = false
        this.recyclerProduct.layoutManager = GridLayoutManager(this.activity, 2)
        this.recyclerProduct.adapter = ProductAdapter(this.activity, Dummy.product())
    }

    private fun init() {
        this.textQuantityProduct = this.binding.textQuantityProduct
        this.textSort = this.binding.textFilter
        this.textLocation = this.binding.textLocation
        this.imageClose = this.binding.imageClose
        this.imageSearch = this.binding.imageSearch
        this.inputSearch = this.binding.inputSearch
        this.inputLayoutSearch = this.binding.inputSearchLayout
        this.recyclerProduct = this.binding.recyclerProduct

        this.activity = requireActivity() as AppCompatActivity

        FontHelper.Lexend.medium(
            this.activity,
            this.textQuantityProduct,
            this.binding.textTitleCar,
            this.binding.textTitleBike,
            this.binding.textTitleDanaTunai
        )

        FontHelper.Lexend.regular(
            this.activity,
            this.textSort,
            this.inputSearch,
            this.textLocation,
            this.binding.textTitleYourLocation,
            this.binding.textTitleChange
        )

        GeneralHelper.makeClickable(this, this.imageSearch, this.imageClose, this.binding.textTitleChange, this.binding.layoutDanaTunai)
    }

    override fun onClick(v: View?) {
        if (v == this.imageClose) {
            this.closeSearchBar()
        } else if (v == this.imageSearch) {
            this.openSearchBar()
        }else if (v == this.binding.textTitleChange){
            BottomSheets.selectLocation(requireActivity() as AppCompatActivity)
        }else if (v == this.binding.layoutDanaTunai) {
            GeneralHelper.move(requireContext(), DanaTunaiActivity::class.java, false)
        }
    }

    private fun openSearchBar() {
        GeneralHelper.visible(this.inputLayoutSearch, this.imageClose)
        GeneralHelper.gone(this.imageSearch)
    }

    private fun closeSearchBar() {
        GeneralHelper.gone(this.inputLayoutSearch, this.imageClose)
        GeneralHelper.visible(this.imageSearch)
    }


}