package com.thoughtworks.todo.mywechat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thoughtworks.todo.mywechat.R
import com.thoughtworks.todo.mywechat.inventory.data.Image

class ImageAdapter(
    private val imagesDataset: List<Image>?,
) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_images, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val circleImage: ImageView = view.findViewById(R.id.circle_Pages)
    }

    override fun getItemCount() = imagesDataset?.size ?:0

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = imagesDataset?.get(position)
        if (item != null) {
            Glide.with(holder.circleImage)
                .load(item.url)
                .into(holder.circleImage)
        }

    }

}