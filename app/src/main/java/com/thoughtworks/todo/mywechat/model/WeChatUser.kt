package com.thoughtworks.todo.mywechat.model

import com.squareup.moshi.Json

data class WeChatUser(
    val id: Int,
    val userName: String,
    val nick: String,
    val avatar: String,
    @field:Json(name = "profile-image")
    val profileImage: String
)