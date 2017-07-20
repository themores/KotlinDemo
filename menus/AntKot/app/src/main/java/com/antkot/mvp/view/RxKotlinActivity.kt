package com.antkot.mvp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.antkot.R
import com.antkot.mvp.contract.UserContract
import com.antkot.mvp.model.entity.User
import com.antkot.mvp.presenter.UserPresenterImp
import kotlinx.android.synthetic.main.activity_rx_kotlin.*

class RxKotlinActivity : AppCompatActivity(), UserContract.IUserView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_kotlin)
        UserPresenterImp(this).getUser("123124")

    }

    override fun onGetUsers(users: MutableList<User>) {
        users.forEach {
            filter.text = it.username
        }

    }

    override fun onGetUser(user: User) {
    }

}
