package com.example.krim_guide.ui.gallery

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.krim_guide.R
import com.example.krim_guide.db.ObjectDesc
import org.intellij.lang.annotations.Language

class GalleryAdapter:RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    private var listArray = emptyList<ObjectDesc>()


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val galleryImageView = view.findViewById<ImageView>(R.id.galleryImageView)
        val galleryTextView = view.findViewById<TextView>(R.id.galleryTextView)
        fun bind (objectDesc: ObjectDesc)
        {

            galleryImageView.setImageResource(objectDesc.image)
            galleryTextView.text = objectDesc.name
            var bundle = bundleOf("objectDescId" to objectDesc.id)
            Log.e("bundle", bundle.toString())
            galleryImageView.setOnClickListener(){
                    view ->
                view.findNavController().navigate(R.id.action_galleryContentFragment_to_fullscreenImageFragment,bundle)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_galery,null))
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var objectDesc = listArray.get(position)
        holder.bind(objectDesc)
    }
    fun setData(objectDesc: List<ObjectDesc>){
        this.listArray = objectDesc
        notifyDataSetChanged()
    }
}