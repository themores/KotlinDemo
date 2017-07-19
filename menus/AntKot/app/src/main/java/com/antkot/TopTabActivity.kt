package com.antkot

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.antkot.tabs.HomeFragment
import com.antkot.tabs.MessageFragment
import kotlinx.android.synthetic.main.activity_top_tab.*

class TopTabActivity : AppCompatActivity() {
    var fragmentList: MutableList<BaseFragment> = mutableListOf(HomeFragment(), MessageFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_tab)
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getCount(): Int {
                return fragmentList.size
            }

            override fun getItem(position: Int): Fragment? {
                return fragmentList[position]
            }

            override fun getPageTitle(position: Int): CharSequence {
                if (position == 0) {
                    return "首页"
                } else {
                    return "消息"
                }
            }
        }
        tablayout.setupWithViewPager(viewPager)
    }
}
