package id.otosales.apps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView
import id.otosales.apps.R
import id.otosales.apps.databinding.ActivityHomeBinding
import id.otosales.apps.fragment.ArticleFragment
import id.otosales.apps.fragment.HomeFragment
import id.otosales.apps.helper.FontHelper
import id.otosales.apps.helper.GeneralHelper
import id.otosales.apps.helper.StringHelper

class HomeActivity : AppCompatActivity(), View.OnClickListener,
    NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var bottomNavbar: BottomNavigationView
    private lateinit var floatingActionButton: FloatingActionButton

    private lateinit var textGreeting: TextView
    private lateinit var textName: TextView

    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityHomeBinding.inflate(this.layoutInflater)
        this.supportActionBar?.hide()
        super.setContentView(this.binding.root)

        this.init()
        this.inflate(HomeFragment())
    }

    private fun inflate(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment)
        transaction.commit()
    }

    private fun init() {
        this.bottomNavbar = this.binding.bottomNavBar
        this.floatingActionButton = this.binding.fab
        this.textGreeting = this.binding.textGreeting
        this.textName = this.binding.textName
        this.frameLayout = this.binding.frameContainer

        FontHelper.Lexend.regular(this, this.textGreeting)
        FontHelper.Lexend.semiBold(this, this.textName)

        this.floatingActionButton.setOnClickListener(this)
        this.binding.circleImageView.setOnClickListener(this)
        this.bottomNavbar.setOnItemSelectedListener(this)
    }

    override fun onClick(v: View?) {
        if (v == this.floatingActionButton) {
            Toast.makeText(this, this.bottomNavbar.selectedItemId.toString(), Toast.LENGTH_SHORT)
                .show()
        } else if (v == this.binding.circleImageView) {
            GeneralHelper.move(this, ProfileActivity::class.java, false)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when {
            StringHelper.isEqual(item.title, this.getString(R.string.article)) -> {
                this.inflate(ArticleFragment())
                item.isChecked = true
            }

            StringHelper.isEqual(item.title, this.getString(R.string.home)) -> {
                this.inflate(HomeFragment())
                item.isChecked = true
            }

            else -> {
                Toast.makeText(this, item.itemId, Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }
}