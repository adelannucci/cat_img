package com.adelannucci.img_app.ui.photo

import android.content.Context

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.adelannucci.img_app.R
import com.squareup.picasso.Picasso

class PhotoGridAdapter(
    private val c: Context,
    private val images: ArrayList<String> = ArrayList<String>()
) :
    RecyclerView.Adapter<PhotoGridAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(c).inflate(R.layout.photo_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val path = images[position]

        Picasso.get()
            .load(path)
            .resize(250, 250)
            .centerCrop()
            .into(holder.image)

        holder.image.setOnClickListener {
            //handle click event on image
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById<ImageView>(R.id.photo)
    }

    fun updateList(images: List<String>) {
        this.images.addAll(images)
        notifyDataSetChanged()
    }
}
