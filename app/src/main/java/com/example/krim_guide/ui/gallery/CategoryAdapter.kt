package com.example.krim_guide.ui.gallery

import android.R.attr.fragment
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.krim_guide.R


class CategoryAdapter(listArray: ArrayList<ListItem>, context: Context):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var listArray = listArray
    var context =context



    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val categoryTextView = view.findViewById<TextView>(R.id.categoryTextView)
        val categoryimageView = view.findViewById<ImageView>(R.id.categoryImageView)
        fun bind(listItem: ListItem, context: Context)
        {
            categoryTextView.text = listItem.category_name
            categoryimageView.setImageResource(listItem.image_id)
            var bundle = bundleOf("category" to listItem.category_name)
            itemView.setOnClickListener(){
                    view ->
                view.findNavController().navigate(R.id.action_nav_gallery_to_galleryContentFragment,bundle)
            }
        }
    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_category, null))
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArray.get(position)
        holder.bind(listItem, context)
    }
}