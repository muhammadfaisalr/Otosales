package id.otosales.apps.fragment

import android.animation.Animator
import android.app.Activity
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import id.otosales.apps.R
import id.otosales.apps.adapter.ProductAdapter
import id.otosales.apps.databinding.FragmentHomeBinding
import id.otosales.apps.dummy.Dummy
import id.otosales.apps.helper.BottomSheets
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper


class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var activity : AppCompatActivity

    private lateinit var textQuantityProduct : TextView
    private lateinit var textSort : TextView
    private lateinit var textLocation : TextView

    private lateinit var cardLocation : CardView

    private lateinit var imageSearch : ImageView
    private lateinit var imageClose : ImageView

    private lateinit var recyclerProduct : RecyclerView

    private lateinit var inputSearch : TextInputEditText
    private lateinit var inputLayoutSearch : TextInputLayout

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
        this.recyclerProduct.layoutManager = GridLayoutManager(this.activity, 2)
        this.recyclerProduct.adapter = ProductAdapter(this.activity, Dummy.product())
        this.recyclerProduct.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 5){
                    if (this@HomeFragment.cardLocation.isVisible){
                        YoYo.with(Techniques.SlideOutUp)
                            .duration(500)
                            .withListener(object : Animator.AnimatorListener{
                                override fun onAnimationStart(animation: Animator?) {

                                }

                                override fun onAnimationEnd(animation: Animator?) {
                                    GeneralHelper.gone(this@HomeFragment.cardLocation)
                                }

                                override fun onAnimationCancel(animation: Animator?) {

                                }

                                override fun onAnimationRepeat(animation: Animator?) {

                                }

                            })
                            .playOn(this@HomeFragment.cardLocation)
                    }
                }else if (dy < 5){
                    if (!this@HomeFragment.cardLocation.isVisible){
                        YoYo.with(Techniques.SlideInDown)
                            .duration(200)
                            .withListener(object : Animator.AnimatorListener{
                                override fun onAnimationStart(animation: Animator?) {

                                }

                                override fun onAnimationEnd(animation: Animator?) {
                                    GeneralHelper.visible(this@HomeFragment.cardLocation)
                                }

                                override fun onAnimationCancel(animation: Animator?) {

                                }

                                override fun onAnimationRepeat(animation: Animator?) {

                                }

                            })
                            .playOn(this@HomeFragment.cardLocation)
                    }
                }
            }
        })
    }

    private fun init() {
        this.textQuantityProduct = this.binding.textQuantityProduct
        this.textSort = this.binding.textFilter
        this.textLocation = this.binding.textLocation
        this.imageClose = this.binding.imageClose
        this.imageSearch = this.binding.imageSearch
        this.inputSearch = this.binding.inputSearch
        this.inputLayoutSearch = this.binding.inputSearchLayout
        this.cardLocation = this.binding.cardLocation
        this.recyclerProduct = this.binding.recyclerProduct

        this.activity = requireActivity() as AppCompatActivity

        FontHelper.Lexend.medium(this.activity, this.textQuantityProduct)
        FontHelper.Lexend.regular(this.activity, this.textSort, this.inputSearch, this.textLocation)

        this.imageSearch.setOnClickListener(this)
        this.imageClose.setOnClickListener(this)
        this.cardLocation.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == this.imageClose){
            this.closeSearchBar()
        }else if (v == this.imageSearch){
            this.openSearchBar()
        }else if (v == this.cardLocation){
            this.openLocationSheet()
        }
    }

    private fun openLocationSheet() {
        BottomSheets.selectLocation(this.activity)
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