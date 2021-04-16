package com.example.krim_guide.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.krim_guide.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        //test category list
        var list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.human, "Человек. Скелет и части тела"))
        list.add(ListItem(R.drawable.zamok, "Замки, пломбы, ЗПУ, металлические хранилища"))
        list.add(ListItem(R.drawable.car, "Транпорт"))
        list.add(ListItem(R.drawable.human, "Человек. Скелет и части тела"))
        list.add(ListItem(R.drawable.zamok, "Замки, пломбы, ЗПУ, металлические хранилища"))
        list.add(ListItem(R.drawable.car, "Транпорт"))
        val categoryListView: RecyclerView = root.findViewById(R.id.categoryListView)
        categoryListView.hasFixedSize()
        categoryListView.layoutManager = LinearLayoutManager(activity)
        categoryListView.adapter = activity?.let { CategoryAdapter(list, it) }

        return root
    }
}
