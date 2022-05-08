package com.royalboe.bakingtutorial.ingredients

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.Util
import com.royalboe.bakingtutorial.R
import com.royalboe.bakingtutorial.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class VideoFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var player: ExoPlayer? = null
    private val contexts by lazy{ requireContext() }
    private val uri = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
    private fun initializePlayer(){
        player = ExoPlayer.Builder(contexts)
            .build()
            .also {
                binding.videoPlayer.player = it
                val mediaItem = MediaItem.fromUri(uri)
                it.setMediaItem(mediaItem)
                it.playWhenReady = playWhenReady
                it.seekTo(currentWindow, playbackPosition)
                it.prepare()
            }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) initializePlayer()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if (Util.SDK_INT < 24 || player == null) initializePlayer()
    }

    @SuppressLint("InlineApi")
    @SuppressWarnings()
    private fun hideSystemUi() {
        binding.videoPlayer.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) releasePlayer()
    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentMediaItemIndex
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}