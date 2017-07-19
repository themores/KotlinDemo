package com.antkot.tabs

import android.content.Context
import com.antkot.BaseFragment
import com.antkot.R
import com.antkot.cardview.CardFragmentPagerAdapter
import com.antkot.cardview.ShadowTransformer
import kotlinx.android.synthetic.main.fragment_home.*


/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/18 下午3:30
 */
class HomeFragment : BaseFragment() {
    var mFragmentCardShadowTransformer: ShadowTransformer? = null
    var mFragmentCardAdapter: CardFragmentPagerAdapter? = null
    override fun getLayoutResources(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        mFragmentCardAdapter = CardFragmentPagerAdapter(childFragmentManager, dpToPixels(2, context))
        mFragmentCardShadowTransformer = ShadowTransformer(viewPager, mFragmentCardAdapter!!)
        viewPager.adapter = mFragmentCardAdapter
        viewPager.setPageTransformer(false, mFragmentCardShadowTransformer)
        viewPager.offscreenPageLimit = 3
        swipelayout.setOnRefreshListener { swipelayout.postDelayed({
            swipelayout.isRefreshing = false
        },3000)}
    }

    fun dpToPixels(dp: Int, context: Context): Float {
        return dp * context.resources.displayMetrics.density
    }

}