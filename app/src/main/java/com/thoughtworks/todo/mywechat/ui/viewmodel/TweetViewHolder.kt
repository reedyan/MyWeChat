package com.thoughtworks.todo.mywechat.ui.viewmodel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.todo.mywechat.inventory.data.*

class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private fun bingWeChatUser(item: WeChatUser){

    }
    private fun bingTweet(item: Tweet){

    }
    private fun bingImage(item: Image){

    }
    private fun bingComment(item: Comment){

    }
    private fun bingUser(item: User){

    }
    fun bing(We){
        when(){
            is Tweet ->bingTweet()
            is WeChatUser -> bingWeChatUser()
            is Image -> bingImage()
            is Comment -> bingComment()
            is User -> bingUser()
        }
    }
    fun bing(){
        when(){
            is Tweet ->bingTweet()
            is WeChatUser -> bingWeChatUser()
            is Image -> bingImage()
            is Comment -> bingComment()
            is User -> bingUser()
        }
    }
}