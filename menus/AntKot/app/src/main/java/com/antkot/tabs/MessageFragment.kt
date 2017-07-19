package com.antkot.tabs

import android.support.v7.widget.LinearLayoutManager
import com.antkot.BaseFragment
import com.antkot.R
import com.antkot.messageview.MessageAdapter
import com.antkot.messageview.MessageBean
import kotlinx.android.synthetic.main.fragment_message.*

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/18 下午3:32
 */
class MessageFragment : BaseFragment() {
    var messageList: MutableList<MessageBean>? = mutableListOf()
    override fun getLayoutResources(): Int {
        return R.layout.fragment_message
    }

    override fun initView() {
        for (i in 0..10) {
            messageList!!.add(MessageBean("其实我就是一条内容", "比克大魔王", 1000))
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MessageAdapter(messageList, context)

    }

}