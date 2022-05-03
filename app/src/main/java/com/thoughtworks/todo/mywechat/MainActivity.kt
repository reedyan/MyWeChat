package com.thoughtworks.todo.mywechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thoughtworks.todo.mywechat.ui.adapter.TweetAdapter
import com.thoughtworks.todo.mywechat.ui.viewmodel.TweetViewModel
//import com.thoughtworks.todo.mywechat.ui.UserViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wechatBackground: ImageView = findViewById(R.id.wechat_background)
        val avatarPage: ImageView = findViewById(R.id.avatar_page)
        val nickName: TextView = findViewById(R.id.user_text)

        val viewModel: TweetViewModel by viewModels()
//        val userViewModel: UserViewModel by viewModels()
        viewModel.getUser()
        viewModel.user.observe(this) { user ->
            user?.let {
                Glide.with(this).load(it.profileImage).into(wechatBackground)
                Glide.with(this).load(it.avatar).into(avatarPage)
                nickName.text = it.nick
            }
        }

        viewModel.tweet.observe(this) {
            tweet -> tweet?.let {
            val recyclerView = findViewById<RecyclerView>(R.id.all_recycleView)
            recyclerView.adapter = TweetAdapter(this, tweet)
            recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
            //recyclerView.setHasFixedSize(true)
        }
        }
    }
}