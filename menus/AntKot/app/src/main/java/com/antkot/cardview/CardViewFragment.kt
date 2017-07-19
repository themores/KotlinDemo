package com.antkot.cardview

import android.support.v7.widget.CardView
import com.antkot.BaseFragment
import com.antkot.R
import kotlinx.android.synthetic.main.fragment_cardview.*
import org.jetbrains.anko.image


/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/18 下午4:31
 */
class CardViewFragment : BaseFragment() {
    override fun initView() {
        cardView.maxCardElevation = cardView.cardElevation * CardAdapter.MAX_ELEVATION_FACTOR
        iv_pic.image = resources.getDrawable(R.mipmap.cardviewitem,null)

    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_cardview
    }

    fun getCardView(): CardView {
        return cardView
    }

}