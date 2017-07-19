package com.antkot

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.antkot.tabs.HomeFragment
import com.antkot.tabs.MessageFragment
import kotlinx.android.synthetic.main.activity_left_menu.*
import kotlinx.android.synthetic.main.app_bar_left_menu.*

class LeftMenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var messageFragment: MessageFragment? = null
    var homeFragment: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_left_menu)

        setSupportActionBar(toolbar)
        fab.setOnClickListener({ view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        })
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.setDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        initLeftMenuFragment()
    }

    private fun initLeftMenuFragment() {
        messageFragment = MessageFragment()
        homeFragment = HomeFragment()
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.add(R.id.fl_content, messageFragment)
        fragmentTrans.add(R.id.fl_content, homeFragment)
        fragmentTrans.commit()
        supportFragmentManager.beginTransaction().show(homeFragment)
                .hide(messageFragment)
                .commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId
        when (id) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                        .show(homeFragment)
                        .hide(messageFragment)
                        .commit()
            }
            R.id.nav_message -> {
                supportFragmentManager.beginTransaction()
                        .show(messageFragment)
                        .hide(homeFragment)
                        .commit()
            }
        }


        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
