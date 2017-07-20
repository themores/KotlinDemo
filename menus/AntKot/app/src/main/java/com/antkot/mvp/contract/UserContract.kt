package com.antkot.mvp.contract

import com.antkot.extends.defaultSchedulers
import com.antkot.mvp.model.entity.User
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.OnErrorNotImplementedException
import io.reactivex.rxkotlin.subscribeBy

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/19 下午8:16
 */
private val onSaveDbStub: (Any) -> Unit = {}
private val onErrorStub: (Throwable) -> Unit = { throw OnErrorNotImplementedException(it) }
private val onFinallyStub: () -> Unit = {}
private val getDataFromDb: () -> Flowable<Any> = { Flowable.concat { } }
private val getDataFromNet: () -> Flowable<Any> = { Flowable.concat { } }

interface UserContract {
    interface IUserView {
        fun onGetUser(user: User)
        fun onGetUsers(users: MutableList<User>)
    }

    interface IUserPresenter {
        fun getUser(userId: String)
        fun getUsers()
    }
}

fun <T : Any> getData(db: Flowable<T> = getDataFromDb() as Flowable<T>,
                      net: Flowable<T> = getDataFromNet() as Flowable<T>,
                      onSuccess: (T) -> Unit,
                      onError: (Throwable) -> Unit = onErrorStub,
                      onFinally: () -> Unit = onFinallyStub,
                      onSaveDb: (T) -> Unit = onSaveDbStub): Disposable {
    return Flowable.just(db, net.doAfterNext { onSaveDb(it) })
            .flatMap { it }
            .doAfterTerminate { onFinally }
            .defaultSchedulers()
            .subscribeBy(
                    onNext = {
                        onSuccess(it)
                    },
                    onError = {
                        onError(it)
                    })
}
