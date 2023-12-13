package com.example.valorant.agents

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.valorant.R

class BrimCFragment : Fragment() {

    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_brim_c, container, false)

        videoView = view.findViewById(R.id.brimCVideo)

        val videoUrl =
            "https://assets.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltc34c3d692ea83f41/5ecad7d0177c51692beb1fe4/Brimstone_C_v001_web.mp4"

        playVideo(videoUrl)

        return view
    }

    private fun playVideo(videoUrl: String) {

        videoView.setMediaController(null)

        val videoUri = Uri.parse(videoUrl)
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
        }

        videoView.start()
    }
}