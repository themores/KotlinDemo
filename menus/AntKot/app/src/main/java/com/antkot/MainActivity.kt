package com.antkot

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.antkot.extends.go
import com.antkot.mvp.view.RxKotlinActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_click_bottom_tab.setOnClickListener { go<BottomTabActivity>() }
        btn_click_left_tab.setOnClickListener { go<LeftMenuActivity>() }
        btn_click_top_tab.setOnClickListener { go<TopTabActivity>() }
        btn_click_pull_tab.setOnClickListener { go<PullMenuActivity>() }
        btn_click_rxkotlin.setOnClickListener { go<RxKotlinActivity>() }
    }
}
