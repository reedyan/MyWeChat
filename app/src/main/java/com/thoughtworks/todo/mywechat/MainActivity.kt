package com.thoughtworks.todo.mywechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thoughtworks.todo.mywechat.inventory.data.WeChatUser
import com.thoughtworks.todo.mywechat.ui.adapter.TweetAdapter
import com.thoughtworks.todo.mywechat.ui.viewmodel.TweetViewModel

//import com.thoughtworks.todo.mywechat.ui.UserViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: TweetViewModel by viewModels()
        viewModel.getUser()
        val tweetAdapter = TweetAdapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.all_recycleView)
        viewModel.user.observe(this) { user ->
            user?.let {
                tweetAdapter.user = user
            }
        }
        recyclerView.adapter = tweetAdapter
        viewModel.tweet.observe(this) { tweet ->
            tweet?.let {
                tweetAdapter.dataset = tweet
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            }
        }
    }
}