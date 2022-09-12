package com.example.comunicalibras.screens.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.comunicalibras.MainActivity
import com.example.comunicalibras.R
import com.example.comunicalibras.databinding.FragmentSignUpBinding
import com.example.comunicalibras.screens.login.LoginFragmentDirections
import com.example.comunicalibras.screens.login.LoginViewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()

        binding.buttonRegister.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() = with(binding) {
        if (nomeInputEditText.text.isNullOrEmpty()) {
            nomeInputLayout.error = getString(R.string.error_nome)
            nomeInputLayout.isErrorEnabled = true
            return
        }
        if (nomeInputLayout.isErrorEnabled) nomeInputLayout.isErrorEnabled = false

        if (passwordInputEditText.text.isNullOrEmpty()) {
            passwordInputLayout.error = getString(R.string.error_password)
            passwordInputLayout.isErrorEnabled = true
            return
        }
        if (passwordInputLayout.isErrorEnabled) passwordInputLayout.isErrorEnabled = false

        if (loginInputEditText.text.isNullOrEmpty()) {
            loginInputLayout.error = getString(R.string.error_login)
            loginInputLayout.isErrorEnabled = true
            return
        }
        if (loginInputLayout.isErrorEnabled) loginInputLayout.isErrorEnabled = false

        viewModel.signUp(
            loginInputEditText.text.toString(),
            passwordInputEditText.text.toString(),
            nomeInputEditText.text.toString()
        )
    }

    private fun observers() {
        viewModel.signUpRequest.observe(viewLifecycleOwner) { professor ->
            (activity as MainActivity).session.saveUserInfo(professor)
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToHomeFragment())
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