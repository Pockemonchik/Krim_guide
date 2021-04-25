package com.example.krim_guide.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        list.add(ListItem(R.drawable.human, "Категория сейфы"))
        list.add(ListItem(R.drawable.zamok, "Категория сейфы"))
        list.add(ListItem(R.drawable.car, "Категория сейфы"))
        list.add(ListItem(R.drawable.human, "Категория замки и пломбы"))
        list.add(ListItem(R.drawable.zamok, "Категория замки и пломбы"))
        list.add(ListItem(R.drawable.car, "Категория замки и пломбы"))
        val categoryListView: RecyclerView = root.findViewById(R.id.categoryListView)
        categoryListView.hasFixedSize()
        categoryListView.layoutManager = LinearLayoutManager(activity)
        categoryListView.adapter = activity?.let { CategoryAdapter(list, it) }

        return root
    }
}
