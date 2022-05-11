package com.thoughtworks.todo.mywechat.network // TODO: 包名和path不对应

import com.thoughtworks.todo.mywechat.inventory.data.Tweet
import com.thoughtworks.todo.mywechat.inventory.data.WeChatUser
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

/*
*   Retrofit  setup
* */

//Add the following constant for the base URL for the web service
private const val WeChat_CIRCLE_JSON_URL =// TODO: 命名不规范
    "https://tw-mobile-xian.github.io/"

//add a Retrofit builder to build and create a Retrofit object
// TODO: 相关的代码最好放在一起
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(WeChat_CIRCLE_JSON_URL)
    .build()

//that defines how Retrofit talks to the web server using HTTP requests.
interface WeChatApiService {
    @GET("moments-data/tweets.json")
    suspend fun getData(): List<Tweet>

    @GET("moments-data/user.json")
    suspend fun getUser(): WeChatUser
}

// you expose the service to the rest of the app using object declaration.
object WeChatDataApi {
    //a lazily initialized retrofit object property named
    val retrofitService: WeChatApiService by lazy {
//            Initialize the retrofitService variable using the retrofit.create() method
        retrofit.create(WeChatApiService::class.java)
    }
}
