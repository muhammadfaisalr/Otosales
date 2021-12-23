package id.otosales.apps.fragment

import android.icu.lang.UCharacter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import id.otosales.apps.adapter.ArticleAdapter
import id.otosales.apps.databinding.FragmentArticleBinding
import id.otosales.apps.dummy.Dummy
import id.otosales.apps.helper.ApiHelper
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.shortcut.BottomSheets
import id.otosales.apps.ui.Loading
import io.reactivex.disposables.CompositeDisposable

class ArticleFragment : Fragment() {

    private lateinit var binding : FragmentArticleBinding

    private lateinit var inputSearch : TextInputEditText
    private lateinit var recyclerArticle : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentArticleBinding.inflate(this.layoutInflater)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.init()
        this.setup()
    }

    private fun setup() {
        val loading = Loading(requireContext())
        loading.setCancelable(false)
        loading.show()
        CompositeDisposable().add(
            ApiHelper.getArticle().subscribe {
                if (it.isSuccessful){
                    val response = it.body()

                    if (response != null){
                        loading.dismiss()
                        this.recyclerArticle.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                        this.recyclerArticle.adapter = ArticleAdapter(requireActivity(), response.data)
                        this.recyclerArticle.addItemDecoration(DividerItemDecoration(requireContext(),RecyclerView.VERTICAL))
                    }
                } else {
                    loading.dismiss()
                    Toast.makeText(requireContext(), it.message(), Toast.LENGTH_SHORT).show()
                    //TODO:: BottomSheet Error
                }
            }
        )

    }

    private fun init() {
        this.inputSearch = this.binding.inputSearch
        this.recyclerArticle = this.binding.recyclerArticle

        FontHelper.Lexend.regular(requireActivity(), this.inputSearch)
    }
}