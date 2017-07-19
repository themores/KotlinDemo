package com.antkot

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.antkot.tabs.HomeFragment
import com.antkot.tabs.MessageFragment

class PullMenuActivity : AppCompatActivity() {
    var homeFragment: HomeFragment? = null
    var messageFragment: MessageFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_menu)
        supportActionBar!!.title = "首页"
        homeFragment = HomeFragment()
        messageFragment = MessageFragment()
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.add(R.id.fl_content, homeFragment)
        fragmentTrans.add(R.id.fl_content, messageFragment)
        fragmentTrans.commit()
        supportFragmentManager.beginTransaction().show(homeFragment)
                .hide(messageFragment)
                .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.left_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)
        when (item!!.itemId) {
            R.id.menu_home -> {
                supportActionBar!!.title = "首页"
                supportFragmentManager.beginTransaction().show(homeFragment)
                        .hide(messageFragment)
                        .commit()

            }
            R.id.menu_message -> {
                supportActionBar!!.title = "消息"
                supportFragmentManager.beginTransaction().show(messageFragment)
                        .hide(homeFragment)
                        .commit()
            }


        }

        return true
    }
}
