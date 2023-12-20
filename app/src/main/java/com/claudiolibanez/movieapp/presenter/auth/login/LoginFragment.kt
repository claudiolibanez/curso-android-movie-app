package com.claudiolibanez.movieapp.presenter.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.claudiolibanez.movieapp.R
import com.claudiolibanez.movieapp.databinding.FragmentLoginBinding
import com.claudiolibanez.movieapp.utils.StateView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.buttonSignIn.setOnClickListener {
            validateData()
        }

        Glide
            .with(requireContext())
            .load(R.drawable.loading)
            .into(binding.progressLoading)
    }

    private fun validateData() {
        val email = binding.editEmail.text.toString()
        val password =  binding.editPassword.text.toString()

        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {
                login(email, password)
            } else {

            }
        } else {

        }
    }

    private fun login(email: String, password: String) {
        viewModel.login(email, password).observe(viewLifecycleOwner) { stateView ->
            when(stateView) {
                is StateView.Loading -> {
                    binding.progressLoading.isVisible = true
                }
                is StateView.Success -> {
                    Toast.makeText(requireContext(), "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                }
                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    Toast.makeText(requireContext(), stateView.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}