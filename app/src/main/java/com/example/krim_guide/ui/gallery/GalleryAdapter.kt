package com.example.krim_guide.ui.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.krim_guide.R
import org.intellij.lang.annotations.Language

class GalleryAdapter(listArray: ArrayList<GalleryItem>,context: Context):
        RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    var listArray = listArray
    var context =context


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val galleryImageView = view.findViewById<ImageView>(R.id.galleryImageView)
        val galleryTextView = view.findViewById<TextView>(R.id.galleryTextView)
        fun bind (galleryItem: GalleryItem,context: Context)
        {

            galleryImageView.setImageResource(galleryItem.image_id)
            galleryTextView.text = galleryItem.gallery_image_name
            galleryImageView.setOnClickListener(){
                    view ->
                view.findNavController().navigate(R.id.action_galleryContentFragment_to_fullscreenImageFragment)
            }

        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_galery,null))
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var galleryItem = listArray.get(position)
        holder.bind(galleryItem,context)
    }
}