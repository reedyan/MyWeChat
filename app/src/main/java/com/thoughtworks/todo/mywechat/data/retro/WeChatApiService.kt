package com.thoughtworks.todo.mywechat.data.retro

import com.thoughtworks.todo.mywechat.model.Tweet
import com.thoughtworks.todo.mywechat.model.WeChatUser
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

/**
 *   Retrofit  setup
 */
// that defines how Retrofit talks to the web server using HTTP requests.
interface WeChatApiService {
    @GET("moments-data/tweets.json")
    suspend fun getData(): List<Tweet>

    @GET("moments-data/user.json")
    suspend fun getUser(): WeChatUser
}

// Add the following constant for the base URL for the web service
private const val WECHAT_CIRCLE_JSON_URL =
    "https://tw-mobile-xian.github.io/"

// add a Retrofit builder to build and create a Retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(WECHAT_CIRCLE_JSON_URL)
    .build()


// you expose the service to the rest of the app using object declaration.
object WeChatDataApi {
    // a lazily initialized retrofit object property named
    val retrofitService: WeChatApiService by lazy {
// Initialize the retrofitService variable using the retrofit.create() method
        retrofit.create(WeChatApiService::class.java)
    }
}
