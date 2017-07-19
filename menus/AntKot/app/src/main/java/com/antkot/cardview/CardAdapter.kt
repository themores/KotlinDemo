package com.antkot.cardview

import android.support.v7.widget.CardView

/**
 * @author liyuan
 * *
 * @description
 * *
 * @email thisuper@qq.com
 * *
 * @date 17/7/18 下午4:42
 */

interface CardAdapter {

    fun getBaseElevation(): Float

    fun getCardViewAt(position: Int): CardView

    fun getCount(): Int

    companion object {
        val MAX_ELEVATION_FACTOR = 8
    }
}
