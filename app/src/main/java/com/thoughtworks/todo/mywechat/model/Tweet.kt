package com.thoughtworks.todo.mywechat.model


data class Tweet(
    val id: Int,
    val content: String?,
    val images: List<Image>?,
    val sender: User?,
    val comments: List<Comment>?,
    val error: String?,
    val unknownError: String?
)

data class Image(
    val id: Int,
    val url: String
)

data class Comment(
    val id: Int,
    val content: String,
    val sender: User
)

data class User(
    val id: Int,
    val userName: String,
    val nick: String,
    val avatar: String
)

