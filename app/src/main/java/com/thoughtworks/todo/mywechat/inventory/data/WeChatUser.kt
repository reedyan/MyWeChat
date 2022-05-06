package com.thoughtworks.todo.mywechat.inventory.data

import com.squareup.moshi.Json

data class WeChatUser(
    val id: Int =0,
    val userName: String,
    val nick: String,
    val avatar: String,
    @field:Json(name = "profile-image")
    val profileImage: String
)

/*
@Entity(tableName = "weChatUser")
data class WeChatUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    @ColumnInfo(name = "userName")
    val userName: String,
    @ColumnInfo(name = "nick")
    val nick: String,
    @ColumnInfo(name = "avatar")
    val avatar: String,
    @field:Json(name = "profile-image")
    @ColumnInfo(name = "profileImage")
    val profileImage: String
)*/
