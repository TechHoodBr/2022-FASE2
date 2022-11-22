package com.example.comunicalibras.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.comunicalibras.MainActivity
import com.example.comunicalibras.NavHostDirections
import com.example.comunicalibras.R
import com.example.comunicalibras.data.models.Professor
import com.example.comunicalibras.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel

    private lateinit var aulaAdapter: AulaAdapter

    lateinit var user: Professor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUserInfo()
        viewModel.getClasses()
        observers()
        initRecycler()
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

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        aulaAdapter = AulaAdapter()
        binding.recyclerClasses.apply {
            layoutManager = linearLayoutManager
            adapter = aulaAdapter
        }
        aulaAdapter.onClick = { aula ->
            aula.video?.let {
                val action = HomeFragmentDirections.actionHomeFragmentToRecordedClassFragment(aula)
                findNavController().navigate(action)
            }
        }
    }

    private fun observers() {
        viewModel.aulaRequest.observe(viewLifecycleOwner) {
            aulaAdapter.submitList(it)
        }

        viewModel.requestFailed.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}