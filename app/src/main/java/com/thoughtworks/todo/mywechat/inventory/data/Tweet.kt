package com.thoughtworks.todo.mywechat.inventory.data


data class Tweet(
    val id: Int, // TODO: 没必要加 =0
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
) {
    // TODO: 无用的代码
    operator fun get(i: Int): Any {
        TODO("Not yet implemented")
    }
}

