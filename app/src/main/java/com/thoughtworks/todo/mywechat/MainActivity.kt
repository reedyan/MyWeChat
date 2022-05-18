package com.thoughtworks.todo.mywechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.todo.mywechat.ui.items.TweetAdapter
import com.thoughtworks.todo.mywechat.ui.TweetViewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: TweetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView =
            findViewById<RecyclerView>(R.id.all_recycleView) // TODO: 可以看一下view binding https://developer.android.com/topic/libraries/view-binding
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val tweetAdapter = TweetAdapter(this)
        recyclerView.adapter = tweetAdapter

        viewModel.user.observe(this) { user ->
            user?.let {
                tweetAdapter.user = user
            }
        }

        viewModel.tweet.observe(this) { tweet ->
            tweet?.let {
                tweetAdapter.dataset = tweet
            }
        }
    }
}
