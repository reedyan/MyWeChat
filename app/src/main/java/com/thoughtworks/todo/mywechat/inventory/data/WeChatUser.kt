package com.thoughtworks.todo.mywechat.inventory.data

import com.squareup.moshi.Json

data class WeChatUser(
    val id: Int = 0,
    val userName: String,
    val nick: String,
    val avatar: String,
    @field:Json(name = "profile-image")
    val profileImage: String
)