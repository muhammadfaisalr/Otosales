package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.otosales.apps.Constant
import id.otosales.apps.R
import id.otosales.apps.adapter.ArticleAdapter
import id.otosales.apps.adapter.BrandAdapter
import id.otosales.apps.databinding.ActivityBrandBinding
import id.otosales.apps.helper.ApiHelper
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.ui.Loading
import io.reactivex.disposables.CompositeDisposable

class BrandActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityBrandBinding
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityBrandBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        this.setContentView(this.binding.root)

        this.extract()

        this.binding.apply {
            FontHelper.Lexend.semiBold(this@BrandActivity, this.textTitle)
            val loading = Loading(this@BrandActivity)
            loading.setCancelable(false)
            loading.show()

            CompositeDisposable().add(
                ApiHelper.getBrand().subscribe {
                    if (it.isSuccessful) {
                        val response = it.body()

                        if (response != null) {
                            loading.dismiss()
                            this.recyclerBrand.layoutManager = LinearLayoutManager(
                                this@BrandActivity,
                                RecyclerView.VERTICAL,
                                false
                            )
                            this.recyclerBrand.adapter =
                                BrandAdapter(this@BrandActivity, response.data!!)
                        }
                    } else {
                        loading.dismiss()
                        Toast.makeText(this@BrandActivity, it.message(), Toast.LENGTH_SHORT).show()
                        //TODO:: BottomSheet Error
                    }
                }
            )

            GeneralHelper.makeClickable(this@BrandActivity, this.imageBack)
        }
    }

    private fun extract() {
        val bundle = this.intent.getBundleExtra(Constant.Key.BUNDLING)
        this.category = bundle!!.getString(Constant.Key.CATEGORY, "")
    }

    override fun onClick(p0: View?) {
        if (p0 == this.binding.imageBack) {
            finish()
        }
    }
}