package com.example.comunicalibras.screens.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.comunicalibras.MainActivity
import com.example.comunicalibras.R
import com.example.comunicalibras.data.models.Professor
import com.example.comunicalibras.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if((activity as MainActivity).session.isLoggedIn()) {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            return
        }

        observers()

        binding.buttonEnter.setOnClickListener {
            signIn()
        }

        binding.textRegister.setOnClickListener {
            signUp()
        }
    }

    private fun signIn() = with(binding) {
        if (emailInputEditText.text.isNullOrEmpty()) {
            emailInputLayout.error = getString(R.string.error_email_invalid)
            emailInputLayout.isErrorEnabled = true
            return
        }

        if (passwordInputEditText.text.isNullOrEmpty()) {
            passwordInputLayout.error = "Senha Inválida"
            passwordInputLayout.isErrorEnabled = true
            return
        }

        viewModel.login(emailInputEditText.text.toString(), passwordInputEditText.text.toString())
    }

    private fun signUp() {
        Toast.makeText(context, "Sign Up clicked", Toast.LENGTH_SHORT).show()
    }

    private fun observers() {
        viewModel.loginRequest.observe(viewLifecycleOwner) { professor ->
            (activity as MainActivity).session.saveUserInfo(professor)
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        }
        viewModel.requestFailed.observe(viewLifecycleOwner) { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}