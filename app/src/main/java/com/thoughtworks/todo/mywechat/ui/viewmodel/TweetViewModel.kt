package com.thoughtworks.todo.mywechat.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.todo.mywechat.inventory.data.Tweet
import com.thoughtworks.todo.mywechat.inventory.data.WeChatUser
import com.thoughtworks.todo.mywechat.network.WeChatDataApi
import kotlinx.coroutines.launch

class TweetViewModel() : ViewModel() {
    init {
        getUser()
        getTweets()
    }

    val user: MutableLiveData<WeChatUser> = MutableLiveData()

    fun getUser() {
//        update UI
        viewModelScope.launch {
            val userResult = WeChatDataApi.retrofitService.getUser()
            user.value = userResult
        }
    }

    val tweet: MutableLiveData<List<Tweet>> = MutableLiveData()
    private fun getTweets() {
        viewModelScope.launch {
            val result = WeChatDataApi.retrofitService.getData()
            val onlinePostDetail: List<Tweet> = result.filter { i ->
                i.error == null && i.unknownError == null && i.images != null
            }
            tweet.value = onlinePostDetail
        }
    }

}