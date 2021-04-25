package com.example.krim_guide.ui.gallery


import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.krim_guide.R
import com.example.krim_guide.db.ObjectDesc
import com.example.krim_guide.db.ObjectDescViewModel


class FullScreenImageFragment : Fragment() {

    private lateinit var mObjectDescViewModel: ObjectDescViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var objectDescId = arguments?.getInt("objectDescId")
        Log.e("id",objectDescId.toString())
        val root = inflater.inflate(R.layout.fragment_fullscreen_image, container, false)
        val fullScreenImage = root.findViewById<ImageView>(R.id.imageViewFullScreen)
        mObjectDescViewModel =  ViewModelProvider(this).get(ObjectDescViewModel::class.java)
        if (objectDescId != null) {
            mObjectDescViewModel.getObjectDescById(objectDescId).observe(viewLifecycleOwner, Observer {objectDesc ->
                fullScreenImage.setImageResource(objectDesc.image)
            })

        }
        return root
    }
}
