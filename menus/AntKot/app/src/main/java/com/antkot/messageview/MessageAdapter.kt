package com.antkot.messageview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.antkot.R
import org.jetbrains.anko.find
import org.jetbrains.anko.image

/**
 *
 * @description
 * @author liyuan
 * @email thisuper@qq.com
 * @date 17/7/18 下午7:52
 */
class MessageAdapter(var datas: MutableList<MessageBean>?, var context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val HEAD: Int = 0
        val CONTENT: Int = 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (getItemViewType(position) == HEAD) {

        } else {
            var messageHolder = holder as MessageViewHolder
            var message: MessageBean = datas!![position - 1]
            messageHolder!!.name.text = message.name
            messageHolder!!.content.text = message.content
            messageHolder!!.header.image = context!!.getDrawable(R.mipmap.cardviewitem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == HEAD) {
            return HeaderView(LayoutInflater.from(context!!).inflate(R.layout.item_message_head, parent, false))
        }
        return MessageViewHolder(LayoutInflater.from(context!!).inflate(R.layout.item_message_view, parent, false))
    }

    override fun getItemCount() = datas?.size?.plus(1) ?: 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return HEAD
        }
        return CONTENT
    }


    class MessageViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var content: TextView = itemView!!.find(R.id.content)
        var name: TextView = itemView!!.find(R.id.name)
        var header: ImageView = itemView!!.find(R.id.header)

        init {

        }
    }


    class HeaderView(itemView: View?) : RecyclerView.ViewHolder(itemView)
}