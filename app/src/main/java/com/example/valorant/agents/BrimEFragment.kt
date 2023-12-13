package com.example.valorant.agents

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.valorant.R

class BrimEFragment : Fragment() {

    private lateinit var videoView: VideoView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_brim_e, container, false)

        videoView = view.findViewById(R.id.brimEVideo)

        val videoUrl =
            "https://assets.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltcf4359fed083686b/5ecad7d198f79d6925dbee07/Brimstone_E_v001_web.mp4"

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