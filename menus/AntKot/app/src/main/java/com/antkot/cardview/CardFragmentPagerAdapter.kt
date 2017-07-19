package com.antkot.cardview

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.CardView
import android.view.ViewGroup
import java.util.*

/**
 * @author liyuan
 * *
 * @description
 * *
 * @email thisuper@qq.com
 * *
 * @date 17/7/18 下午4:39
 */

class CardFragmentPagerAdapter(fm: FragmentManager, private val mBaseElevation: Float) : FragmentStatePagerAdapter(fm), CardAdapter {

    private val mFragments: MutableList<CardViewFragment>

    init {
        mFragments = ArrayList<CardViewFragment>()

        for (i in 0..4) {
            addCardFragment(CardViewFragment())
        }
    }

    override fun getBaseElevation(): Float {
        return mBaseElevation
    }

    override fun getCardViewAt(position: Int): CardView {
        return mFragments[position].getCardView()
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        mFragments[position] = fragment as CardViewFragment
        return fragment
    }

    fun addCardFragment(fragment: CardViewFragment) {
        mFragments.add(fragment)
    }

}
