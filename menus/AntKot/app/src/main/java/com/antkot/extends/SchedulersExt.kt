package com.antkot.extends

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/19 下午6:16
 */


inline fun <T> Flowable<T>.defaultSchedulers(): Flowable<T> = this.compose { it ->
    it.subscribeOn(io()).observeOn(mainThread())
}
