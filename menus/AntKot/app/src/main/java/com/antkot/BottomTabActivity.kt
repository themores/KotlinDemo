package com.antkot

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.antkot.tabs.HomeFragment
import com.antkot.tabs.MessageFragment
import kotlinx.android.synthetic.main.activity_bottom_tab.*
import org.jetbrains.anko.textColor

class BottomTabActivity : AppCompatActivity(), View.OnClickListener {

    var homeFragment: HomeFragment? = null
    var messageFragment: MessageFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_tab)
        initTabButton()
        initFragment(savedInstanceState)
    }

    private fun initTabButton() {
        rb_home.isChecked = true
        rb_home.setOnClickListener(this)
        rb_message.setOnClickListener(this)
    }

    private fun initFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            //异常情况
            val mFragments: List<Fragment> = supportFragmentManager.fragments
            for (item in mFragments) {
                if (item is HomeFragment) {
                    homeFragment = item
                }
                if (item is MessageFragment) {
                    messageFragment = item
                }

            }
        } else {
            homeFragment = HomeFragment()
            messageFragment = MessageFragment()
            val fragmentTrans = supportFragmentManager.beginTransaction()
            fragmentTrans.add(R.id.fl_content, homeFragment)
            fragmentTrans.add(R.id.fl_content, messageFragment)
            fragmentTrans.commit()
        }
        supportFragmentManager.beginTransaction().show(homeFragment)
                .hide(messageFragment)
                .commit()
    }

    private fun clearTabState() {
        rb_home.textColor = (Color.GRAY)
        rb_home.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.mipmap.home_default), null, null)
        rb_message.textColor = (Color.GRAY)
        rb_message.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.mipmap.message_default), null, null)

    }

    override fun onClick(v: View?) {
        clearTabState()
        when (v!!.id) {
            R.id.rb_home -> {
                rb_home.isChecked = true
                rb_home.setTextColor(Color.BLACK)
                rb_home.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.mipmap.home_press), null, null)
                supportFragmentManager.beginTransaction().show(homeFragment).hide(messageFragment).commit()

            }
            R.id.rb_message -> {
                rb_message.isChecked = true
                rb_message.setTextColor(Color.BLACK)
                rb_message.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.mipmap.message_press), null, null)
                supportFragmentManager.beginTransaction().show(messageFragment).hide(homeFragment).commit()
            }

        }
    }

}
