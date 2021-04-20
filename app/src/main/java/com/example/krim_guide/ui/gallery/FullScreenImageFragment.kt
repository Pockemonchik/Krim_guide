package com.example.krim_guide.ui.gallery


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.krim_guide.R


class FullScreenImageFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_fullscreen_image, container, false)
        val fullScreenImage = root.findViewById<ImageView>(R.id.imageViewFullScreen)
        fullScreenImage.setImageResource(R.drawable.key2)
        return root
    }
}
