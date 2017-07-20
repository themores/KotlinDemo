package com.antkot.mvp.utils

import com.antkot.mvp.model.entity.User
import io.reactivex.Flowable

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/19 下午8:45
 */
class UserRequest {

    fun getUsers(): Flowable<MutableList<User>> {
        var userList: MutableList<User> = mutableListOf()
        (1..10).mapTo(userList) { User("username for request" + it, it) }
        return Flowable.just(userList)
    }
}