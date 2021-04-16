package com.example.krim_guide.ui.gallery

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
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
