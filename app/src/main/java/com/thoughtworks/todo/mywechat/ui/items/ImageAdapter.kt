package com.thoughtworks.todo.mywechat.ui.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thoughtworks.todo.mywechat.R
import com.thoughtworks.todo.mywechat.model.Image


class ImageAdapter(
    private val imagesDataset: List<Image>?,
) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val circleImage: ImageView = view.findViewById(R.id.imageview_circlepage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_images, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = imagesDataset?.size ?: 0

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = imagesDataset?.get(position)
        if (item != null) {
            when (imagesDataset?.size) {
                1 -> {
                    Glide.with(holder.circleImage)
                        .load(item.url)
                        .apply(RequestOptions().override(200, 200))
                        .into(holder.circleImage)
                }
                else -> {
                    Glide.with(holder.circleImage)
                        .load(item.url)
                        .apply(RequestOptions().override(150, 150))
                        .into(holder.circleImage)
                }
            }
        }
    }

}
