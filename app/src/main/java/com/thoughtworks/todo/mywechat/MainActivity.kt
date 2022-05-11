package com.thoughtworks.todo.mywechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.todo.mywechat.ui.adapter.TweetAdapter
import com.thoughtworks.todo.mywechat.ui.viewmodel.TweetViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: TweetViewModel by viewModels() // TODO: 一般会放到onCreate方法外面 （这里放在这也可以，只有onCreate方法中使用）
        viewModel.getUser()
        val tweetAdapter = TweetAdapter(this) // TODO: 使用时再初始化，代码逻辑按块区分
        val recyclerView = findViewById<RecyclerView>(R.id.all_recycleView) // TODO: 可以看一下view binding https://developer.android.com/topic/libraries/view-binding

        viewModel.user.observe(this) { user ->
            user?.let {
                tweetAdapter.user = user
            }
        }
        recyclerView.adapter = tweetAdapter // TODO: 应该在监听数据之前设置好adapter
        viewModel.tweet.observe(this) { tweet ->
            tweet?.let {
                tweetAdapter.dataset = tweet
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false) // TODO: 在初始化recyclerView的使用调用一次即可
            }
        }
    }
}
