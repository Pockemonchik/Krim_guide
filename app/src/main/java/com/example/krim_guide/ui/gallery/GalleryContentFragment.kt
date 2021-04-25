package com.example.krim_guide.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.krim_guide.R
import com.example.krim_guide.db.ObjectDescDao
import com.example.krim_guide.db.ObjectDescViewModel
import java.util.EnumSet.of
import java.util.List.of


class GalleryContentFragment : Fragment() {
    private lateinit var mObjectDescViewModel: ObjectDescViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_gallery_content, container, false)
        val galleryListView: RecyclerView = root.findViewById(R.id.galleryListView)
        val adapter =  GalleryAdapter()
        val category = arguments?.getString("category")
        galleryListView.layoutManager = GridLayoutManager(activity,2)
        galleryListView.adapter = adapter

        mObjectDescViewModel =  ViewModelProvider(this).get(ObjectDescViewModel::class.java)
        if (category != null) {
            mObjectDescViewModel.getObjectDescByCategory(category).observe(viewLifecycleOwner, Observer {objectDesc ->
                adapter?.setData(objectDesc)
            })
        }

        return root
    }


}