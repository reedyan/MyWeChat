package com.thoughtworks.todo.mywechat.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
*  create data structure
* */
@Entity
data class Tweet(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "content")
    val content: String?,
    @ColumnInfo(name = "images")
    val images: List<Image>?,
    @ColumnInfo(name = "sender")
    val sender: User?,
    @ColumnInfo(name = "comments")
    val comments: List<Comment>?,
    @ColumnInfo(name = "error")
    val error: String?,
    @ColumnInfo(name = "unknownError")
    val unknownError: String?
)
@Entity
data class Image(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "url")
    val url: String)
@Entity
data class Comment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "sender")
    val sender: User
)

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "userName")
    val userName: String,
    @ColumnInfo(name = "nick")
    val nick: String,
    @ColumnInfo(name = "avatar")
    val avatar: String)
