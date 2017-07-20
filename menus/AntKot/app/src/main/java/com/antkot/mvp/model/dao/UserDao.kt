package com.antkot.mvp.model.dao

import com.antkot.mvp.model.entity.User
import io.reactivex.Flowable

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/19 下午8:01
 */
class UserDao {

    fun insertUser(user: User): Unit {

    }

    fun getUser(userId: String): User {
        var user = User(userId, 0)
        user.username = userId
        user.userAge = 10
        return user
    }

    fun getUsers(): Flowable<MutableList<User>> {
        var userList: MutableList<User> = mutableListOf()
        (1..10).mapTo(userList) { getUser("username" + it) }
        return Flowable.just(userList)
    }
}