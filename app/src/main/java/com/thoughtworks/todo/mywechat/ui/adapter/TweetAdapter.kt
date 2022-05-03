package com.thoughtworks.todo.mywechat.ui.adapter

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
import com.thoughtworks.todo.mywechat.inventory.data.Tweet

class TweetAdapter(
    private val context: Context,
    private val dataset: List<Tweet>,
) : RecyclerView.Adapter<TweetAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textContent.text = item.content
        holder.textContent.isVisible = !holder.textContent.text.isEmpty()

        Glide.with(holder.avatarImage)
            .load(item.sender?.avatar)
            .into(holder.avatarImage)

        holder.nameText.text = item.sender?.nick

        holder.allCircleImage.adapter = ImageAdapter(item.images)
        holder.allCircleImage.layoutManager = GridLayoutManager(context, 3,)


        holder.allCommentText.adapter = CommentAdapter(item.comments)
        holder.allCommentText.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
    }

    /*override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }*/
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //     沙发 content
        val textContent: TextView = view.findViewById(R.id.text_content)

        //     朋友圈 用户照片
        val avatarImage: ImageView = view.findViewById(R.id.avatar_image)

        //     朋友圈用户名
        val nameText: TextView = view.findViewById(R.id.user_name)

        //    朋友圈照片
        val allCircleImage: RecyclerView = view.findViewById(R.id.image_recycleView)

        //     朋友圈comment
        val allCommentText: RecyclerView = view.findViewById(R.id.comment_recycleView)
    }
    override fun getItemCount() = dataset.size
}