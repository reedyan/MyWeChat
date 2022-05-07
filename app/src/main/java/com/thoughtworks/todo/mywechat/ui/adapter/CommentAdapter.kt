package com.thoughtworks.todo.mywechat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.todo.mywechat.R
import com.thoughtworks.todo.mywechat.inventory.data.Comment

class CommentAdapter(
    private val commendsDataset: List<Comment>?,
) : RecyclerView.Adapter<CommentAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_comments, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val commentText: TextView = view.findViewById(R.id.text_comment)
        val commentContent: TextView = view.findViewById(R.id.comment_content)
    }

    override fun getItemCount() = commendsDataset?.size ?: 0

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = commendsDataset?.get(position)
        if (item != null) {
            holder.commentText.text = item.sender.nick
            holder.commentContent.text = ":" + item.content
        }

    }

}