package com.example.krim_guide.search

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.krim_guide.MainActivity
import com.example.krim_guide.R
import com.example.krim_guide.db.ObjectDesc


class SearchListAdapter(val activity: MainActivity) : RecyclerView.Adapter<SearchListAdapter.ViewHolder>(){

    private var listArray = emptyList<ObjectDesc>()
    lateinit var navController: NavController
    private var listener: (() -> Unit)? = null

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {


        val searchItemCategoryTextView: TextView = view.findViewById(R.id.searchItemCategoryTextView)
        val searchItemNameTextView: TextView = view.findViewById(R.id.searchItemNameTextView)
        val searchItemImageView: ImageView = view.findViewById(R.id.searchItemImageView)



        fun bind (objectDesc: ObjectDesc)
        {

            searchItemCategoryTextView.text = objectDesc.category
            searchItemNameTextView.text = objectDesc.name
            searchItemImageView.setImageResource(objectDesc.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_search,null))
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var objectDesc = listArray[position]
        Log.e("bindholder", objectDesc.toString())
        holder.bind(objectDesc)
        var bundle = bundleOf("objectDescId" to objectDesc.id)
        Log.e("bundle", bundle.toString())
        holder.itemView.setOnClickListener(){
            Navigation.findNavController(activity, R.id.nav_host_fragment).navigate(R.id.fullscreenImageFragment,bundle)
            val searchListView : RecyclerView = activity.findViewById(R.id.searchListView)
            searchListView.visibility= GONE

        }
    }



    fun setData(objectDesc: List<ObjectDesc>){
        this.listArray = objectDesc
        Log.e("set data", objectDesc.toString())
        notifyDataSetChanged()
    }
}