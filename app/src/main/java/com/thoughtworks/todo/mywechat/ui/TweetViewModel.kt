package com.thoughtworks.todo.mywechat.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.todo.mywechat.model.Tweet
import com.thoughtworks.todo.mywechat.model.WeChatUser
import com.thoughtworks.todo.mywechat.data.retro.WeChatDataApi
import kotlinx.coroutines.launch

class TweetViewModel() : ViewModel() {
    init {
        getUser()
        getTweets()
    }

    val user: MutableLiveData<WeChatUser> = MutableLiveData()
    val tweet: MutableLiveData<List<Tweet>> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            val userResult = WeChatDataApi.retrofitService.getUser() // TODO: 没有做异常处理
            user.value = userResult
        }
    }

    private fun getTweets() {
        viewModelScope.launch {
            val result = WeChatDataApi.retrofitService.getData() // TODO: 没有做异常处理
            val onlinePostDetail: List<Tweet> = result.filter { i ->
                i.error == null && i.unknownError == null && i.images != null
            }
            tweet.value = onlinePostDetail
        }
    }

}
