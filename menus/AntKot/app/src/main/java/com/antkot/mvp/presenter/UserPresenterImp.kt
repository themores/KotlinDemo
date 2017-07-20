package com.antkot.mvp.presenter

import com.antkot.mvp.contract.UserContract
import com.antkot.mvp.contract.getData
import com.antkot.mvp.model.dao.UserDao
import com.antkot.mvp.model.entity.User
import com.antkot.mvp.utils.UserRequest

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/19 下午8:18
 */
class UserPresenterImp(val view: UserContract.IUserView) : UserContract.IUserPresenter {
    private lateinit var userDao: UserDao
    private lateinit var userRequest: UserRequest

    override fun getUsers() {
        //1. from the db  2.from the net
        userDao = UserDao()
        userRequest = UserRequest()
        getData(db = userDao.getUsers(),
                net = userRequest.getUsers(),
                onSuccess = {
                    view.onGetUsers(it)
                })

    }

    override fun getUser(userId: String) {
        userDao = UserDao()
        userRequest = UserRequest()
        getData(net = userRequest.getUsers(),
                onSuccess = {
                    view.onGetUsers(it)
                },
                onSaveDb = {
                    userDao.insertUser(User(it[0].username, it[0].userAge))
                })
    }
}
