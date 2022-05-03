package com.thoughtworks.todo.mywechat.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
*  create data structure
* */
data class Tweet(
    val id: Int = 0,
    val content: String?,
    val images: List<Image>?,
    val sender: User?,
    val comments: List<Comment>?,
    val error: String?,
    val unknownError: String?
)

data class Image(
    val id: Int = 0,
    val url: String
)

data class Comment(
    val id: Int = 0,
    val content: String,
    val sender: User
)

data class User(
    val id: Int = 0,
    val userName: String,
    val nick: String,
    val avatar: String
)

/*
*  create data structure
* *//*

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
*/
