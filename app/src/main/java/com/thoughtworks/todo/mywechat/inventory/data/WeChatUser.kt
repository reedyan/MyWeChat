package com.thoughtworks.todo.mywechat.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

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
)