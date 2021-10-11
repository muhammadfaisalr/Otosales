package id.otosales.apps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private var fragments = ArrayList<Fragment>()
    private var titles = ArrayList<String>()

    override fun getCount(): Int {
        return this.fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return this.fragments[position]
    }

    fun addFragment(fragment : Fragment, title : String){
        this.fragments.add(fragment)
        this.titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return this.titles[position]
    }
}