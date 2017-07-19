package com.antkot.extends

import android.app.Activity
import android.content.Context
import android.content.Intent
import java.io.Serializable

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@163.com
 * @date 17/7/18 下午2:45
 */

inline fun <reified T : Activity> Context.go(vararg params: Pair<String, Any>) {
    var intent = Intent(this, T::class.java)
    //在这里添加参数，可由自己自行添加其他类型
    params.forEach {
        val value = it.second
        when (value) {
            null -> intent.putExtra(it.first, null as Serializable)
            is Int -> intent.putExtra(it.first, value)
            is Long -> intent.putExtra(it.first, value)
            is String -> intent.putExtra(it.first, value)
        }
    }

    startActivity(intent)

}

inline fun <reified T : Activity> Activity.go(requestCode: Int) {
    var intent = Intent(this, T::class.java)
    startActivityForResult(intent, requestCode)
}

