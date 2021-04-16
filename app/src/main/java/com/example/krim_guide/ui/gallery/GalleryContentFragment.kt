package com.example.krim_guide.ui.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.krim_guide.R




class GalleryContentFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_gallery_content, container, false)
        var list = ArrayList<GalleryItem>()
        list.add(GalleryItem(R.drawable.key, "Реечный замок"))
        list.add(GalleryItem(R.drawable.key2, "Сейф"))
        list.add(GalleryItem(R.drawable.key, "Реечный замок"))
        list.add(GalleryItem(R.drawable.key2, "Сейф"))
        list.add(GalleryItem(R.drawable.key, "Реечный замок"))
        list.add(GalleryItem(R.drawable.key2, "Сейф"))

        val galleryListView: RecyclerView = root.findViewById(R.id.galleryListView)
       // galleryListView.hasFixedSize()
        galleryListView.layoutManager = GridLayoutManager(activity,2)
        galleryListView.adapter = activity?.let { GalleryAdapter(list, it) }

        return root
    }


}