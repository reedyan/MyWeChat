package com.thoughtworks.todo.mywechat.ui.items

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thoughtworks.todo.mywechat.R
import com.thoughtworks.todo.mywechat.model.Tweet
import com.thoughtworks.todo.mywechat.model.WeChatUser

class TweetAdapter(
    private val context: Context,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var user: WeChatUser? = null
    var dataset: List<Tweet> = emptyList()

    companion object {
        const val VIEW_TYPE_USER = 0
        const val VIEW_TYPE_TWEET = 1
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val weChatBackground: ImageView = view.findViewById(R.id.wechat_background)
        val weChatUserName: TextView = view.findViewById(R.id.user_text)
        val weChatAvatar: ImageView = view.findViewById(R.id.avatar_page)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textContent: TextView = view.findViewById(R.id.text_content)

        val avatarImage: ImageView = view.findViewById(R.id.avatar_image)

        val nameText: TextView = view.findViewById(R.id.user_name)

        val allCircleImage: RecyclerView = view.findViewById(R.id.image_recycleView)

        val allCommentText: RecyclerView = view.findViewById(R.id.comment_recycleView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val userAdapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_wechatuser, parent, false)
        val circleAdapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tweet, parent, false)
        return when (viewType) {
            VIEW_TYPE_USER -> UserViewHolder(userAdapterLayout)
            else -> ItemViewHolder(circleAdapterLayout)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_USER
            else -> VIEW_TYPE_TWEET
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.weChatUserName.text = user?.nick
            Glide.with(context)
                .load(user?.profileImage)
                .into(holder.weChatBackground)
            Glide.with(context)
                .load(user?.avatar)
                .into(holder.weChatAvatar)
        } else if (holder as? ItemViewHolder != null) {
            val item = dataset[position - 1]
            holder.textContent.text = item.content
            holder.textContent.isVisible = !holder.textContent.text.isEmpty()

            Glide.with(context)
                .load(item.sender?.avatar)
                .into(holder.avatarImage)

            holder.nameText.text = item.sender?.nick

            holder.allCircleImage.adapter = ImageAdapter(item.images)

            holder.allCircleImage.layoutManager = GridLayoutManager(context, 3)

            holder.allCommentText.adapter = CommentAdapter(item.comments)
            holder.allCommentText.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun getItemCount() = dataset.size + 1


}
