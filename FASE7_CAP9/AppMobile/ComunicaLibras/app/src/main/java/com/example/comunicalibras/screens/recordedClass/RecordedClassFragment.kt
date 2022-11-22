package com.example.comunicalibras.screens.recordedClass

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.comunicalibras.MainActivity
import com.example.comunicalibras.NavHostDirections
import com.example.comunicalibras.R
import com.example.comunicalibras.data.models.Professor
import com.example.comunicalibras.databinding.FragmentRecordedClassBinding

class RecordedClassFragment : Fragment() {

    private var _binding: FragmentRecordedClassBinding? = null
    private val binding get() = _binding!!

    private val args: RecordedClassFragmentArgs by navArgs()
    private val aula by lazy { args.aula }
    private lateinit var user: Professor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecordedClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUserInfo()
        setClassInfo()
        setPlayer()
    }

    private fun setClassInfo() {
        binding.classTitle.text = aula.titulo
        binding.classTeacher.text = aula.professor.nome
        binding.classDescription.text = aula.descricao.replace("\\n", "\n")
    }

    private fun setPlayer() = with(binding) {
        aula.video?.let {
            val uri: Uri = Uri.parse(aula.video)
            videoView.setVideoURI(uri)

            val mediaController = MediaController(requireContext())
            mediaController.setAnchorView(videoView)
            mediaController.setMediaPlayer(videoView)
            videoView.setMediaController(mediaController)

            playIcon.setOnClickListener {
                playIcon.visibility = GONE
                videoView.start()
            }
            videoView.setOnClickListener {
                if (videoView.isPlaying) videoView.pause()
                else videoView.start()
            }
        }
    }

    private fun setUserInfo() {
        user = (activity as MainActivity).session.getUserInfo()
        Glide.with(this)
            .load(user.avatar)
            .circleCrop()
            .into(binding.userImage)
        binding.appBarTitle.text = getString(R.string.appbar_title, user.nome)
        binding.buttonSignOut.setOnClickListener {
            (activity as MainActivity).session.logOut()
            findNavController().navigate(NavHostDirections.actionGlobalLoginFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}